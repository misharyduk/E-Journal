CREATE SEQUENCE journal_id_sequence INCREMENT BY 1;
CREATE SEQUENCE lesson_id_sequence INCREMENT BY 1;
CREATE SEQUENCE acad_module_id_sequence INCREMENT BY 1;
CREATE SEQUENCE exer_work_id_sequence INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS journal(
    semester_number VARCHAR(10) CHECK(semester_number IN ('FIRST', 'SECOND')),
    journal_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    group_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    lecture_teacher_id BIGINT NOT NULL,
    practical_teacher_id BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS lesson(
    lesson_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    lesson_type VARCHAR(100) NOT NULL,
    lesson_date TIMESTAMP NOT NULL,
    lesson_order INT NOT NULL,
    auditory VARCHAR(50) NOT NULL,
    journal_id BIGINT
);

ALTER TABLE lesson ADD FOREIGN KEY (journal_id) REFERENCES journal(journal_id) ON DELETE CASCADE;

CREATE TABLE IF NOT EXISTS academic_module(
    acad_module_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    module_number INT NOT NULL,
    journal_id BIGINT NOT NULL
);

ALTER TABLE academic_module ADD FOREIGN KEY (journal_id) REFERENCES journal(journal_id) ON DELETE CASCADE;

CREATE TABLE IF NOT EXISTS exercise_work(
    exer_work_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    work_number INT NOT NULL,
    exercise_work_type VARCHAR(50) NOT NULL CHECK (exercise_work_type IN ('LABORATORY', 'INDIVIDUAL')),
    academic_module_id BIGINT NOT NULL
);

ALTER TABLE exercise_work ADD FOREIGN KEY (academic_module_id) REFERENCES academic_module(acad_module_id) ON DELETE CASCADE;
