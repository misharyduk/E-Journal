CREATE SEQUENCE journal_id_sequence INCREMENT BY 1;
CREATE SEQUENCE lesson_id_sequence INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS journal(
    journal_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    group_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    teacher_id BIGINT NOT NULL
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