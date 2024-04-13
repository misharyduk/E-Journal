CREATE SEQUENCE journal_id_sequence INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS journal(
    journal_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    group_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    teacher_id BIGINT NOT NULL
);

-- ALTER TABLE student ADD FOREIGN KEY (group_id) REFERENCES app_group(group_id) ON DELETE SET NULL;