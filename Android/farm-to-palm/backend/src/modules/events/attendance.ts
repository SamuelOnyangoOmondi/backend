import type { FastifyInstance, FastifyRequest, FastifyReply } from 'fastify';
import { db } from '../../db/knex.js';
import { attendanceBulkBody } from '../../shared/validation/schemas.js';
import { terminalAuth } from '../../shared/middleware/auth.js';
import { upsertAttendanceToSupabase } from '../../supabase/attendance.js';

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
    const supabaseResult = await upsertAttendanceToSupabase(parsed.data.events, schoolIdFromToken);
    if (!supabaseResult.ok) {
      req.log?.error({ err: supabaseResult.error, eventCount: parsed.data.events.length }, 'Supabase attendance upsert failed - SupaSchool will not show records');
      // Still return 200 so device marks as synced; data is in Knex. Fix SupaSchool config separately.
    }
    return reply.send({ count: parsed.data.events.length });
  });
}
