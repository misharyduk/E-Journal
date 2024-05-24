CREATE SEQUENCE IF NOT EXISTS student_id_sequence INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS group_id_sequence INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS student(
    student_id BIGINT NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255) NOT NULL,
    mobile_phone VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    group_id BIGINT
);

CREATE TABLE IF NOT EXISTS app_group(
    group_id BIGINT NOT NULL PRIMARY KEY,
    group_number INTEGER NOT NULL,
    department_id BIGINT
);

ALTER TABLE student ADD FOREIGN KEY (group_id) REFERENCES app_group(group_id) ON DELETE SET NULL;