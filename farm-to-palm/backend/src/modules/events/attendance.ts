import type { FastifyInstance, FastifyRequest, FastifyReply } from 'fastify';
import { db } from '../../db/knex.js';
import { attendanceBulkBody } from '../../shared/validation/schemas.js';
import { terminalAuth } from '../../shared/middleware/auth.js';

export default async function (app: FastifyInstance) {
  app.post('/v1/events/attendance/bulk', { preHandler: terminalAuth }, async (req: FastifyRequest, reply: FastifyReply) => {
    const parsed = attendanceBulkBody.safeParse(req.body);
    if (!parsed.success) {
      return reply.status(400).send({ error: 'Invalid body' });
    }
    const now = new Date();
    const schoolIdFromToken = (req as any).schoolId;
    for (const e of parsed.data.events) {
      let studentId = e.studentId;
      if (!studentId && e.externalId) {
        const student = await db('students').where({ school_id: e.schoolId ?? schoolIdFromToken, external_id: e.externalId }).first();
        studentId = student?.id;
      }
      if (!studentId) continue;
      await db('attendance_events').insert({
        id: e.eventId,
        student_id: studentId,
        terminal_id: e.terminalId,
        school_id: e.schoolId ?? schoolIdFromToken,
        ts: e.ts,
        confidence: e.confidence,
        created_at: now,
        updated_at: now,
      }).onConflict('id').ignore();
    }
    return reply.send({ count: parsed.data.events.length });
  });
}
