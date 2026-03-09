-- Palm enrollment status for Farm-to-Palm biometric device
-- Stores only metadata (no template data); actual templates stay encrypted on backend

CREATE TABLE IF NOT EXISTS public.palm_enrollment (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  student_id uuid NOT NULL REFERENCES public.students(id) ON DELETE CASCADE,
  enrolled_at timestamptz NOT NULL DEFAULT now(),
  device_id text,
  created_at timestamptz NOT NULL DEFAULT now(),
  UNIQUE (student_id)
);

CREATE INDEX IF NOT EXISTS idx_palm_enrollment_student ON public.palm_enrollment (student_id);

ALTER TABLE public.palm_enrollment ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Allow all for palm_enrollment" ON public.palm_enrollment FOR ALL USING (true) WITH CHECK (true);
