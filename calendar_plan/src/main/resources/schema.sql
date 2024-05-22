CREATE SEQUENCE calendar_plan_id_sequence INCREMENT BY 1;
CREATE SEQUENCE calendar_plan_record_id_sequence INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS calendar_plan_record
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    lesson_id BIGINT NOT NULL,
    lesson_number INT,
    lesson_date TIMESTAMP NOT NULL,
    theme_name CLOB,
    ind_assignment CLOB,
    ind_assign_date TIMESTAMP,
    calendar_plan_id BIGINT
)

CREATE TABLE IF NOT EXISTS calendar_plan
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    journal_id BIGINT NOT NULL
)

ALTER TABLE calendar_plan_record ADD FOREIGN KEY (calendar_plan_id) REFERENCES calendar_plan (id) ON DELETE CASCADE;