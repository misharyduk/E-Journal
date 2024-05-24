CREATE SEQUENCE IF NOT EXISTS university_id_sequence INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS faculty_id_sequence INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS department_id_sequence INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS subject_id_sequence INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS teacher_id_sequence INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS address_id_sequence INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS university(
    university_id BIGINT NOT NULL PRIMARY KEY,
    university_name VARCHAR(255) NOT NULL,
    university_description TEXT DEFAULT NULL,
    address_id BIGINT DEFAULT NULL,
    mobile_phone VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    accreditation VARCHAR(255) DEFAULT NULL,
    rector_id BIGINT
);

CREATE TABLE IF NOT EXISTS faculty(
    faculty_id BIGINT NOT NULL PRIMARY KEY,
    faculty_name VARCHAR(255) NOT NULL,
    faculty_description TEXT DEFAULT NULL,
    address_id BIGINT DEFAULT NULL,
    office_number VARCHAR(255) DEFAULT NULL,
    mobile_phone VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    dean_id BIGINT,
    university_id BIGINT
);

CREATE TABLE IF NOT EXISTS department(
    department_id BIGINT NOT NULL PRIMARY KEY,
    department_name VARCHAR(255) NOT NULL,
    department_description TEXT DEFAULT NULL,
    address_id BIGINT DEFAULT NULL,
    office_number VARCHAR(255) DEFAULT NULL,
    mobile_phone VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    head_of_department_id BIGINT,
    faculty_id BIGINT
);

CREATE TABLE IF NOT EXISTS teacher(
    teacher_id BIGINT NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) DEFAULT NULL,
    mobile_phone VARCHAR(255) DEFAULT NULL,
    faculty_id BIGINT
);

CREATE TABLE IF NOT EXISTS subject(
    subject_id BIGINT NOT NULL PRIMARY KEY,
    subject_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS address(
    address_id BIGINT NOT NULL PRIMARY KEY,
    country VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL,
    zip_code VARCHAR(255) NOT NULL
);

ALTER TABLE university ADD FOREIGN KEY (rector_id) REFERENCES teacher(teacher_id) ON DELETE CASCADE;
ALTER TABLE university ADD FOREIGN KEY (address_id) REFERENCES address(address_id) ON DELETE SET NULL;

ALTER TABLE faculty ADD FOREIGN KEY (dean_id) REFERENCES teacher(teacher_id) ON DELETE SET NULL;
ALTER TABLE faculty ADD FOREIGN KEY (university_id) REFERENCES university(university_id) ON DELETE CASCADE;
ALTER TABLE faculty ADD FOREIGN KEY (address_id) REFERENCES address(address_id) ON DELETE SET NULL;

ALTER TABLE department ADD FOREIGN KEY (head_of_department_id) REFERENCES teacher(teacher_id) ON DELETE SET NULL;
ALTER TABLE department ADD FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id) ON DELETE CASCADE;
ALTER TABLE department ADD FOREIGN KEY (address_id) REFERENCES address(address_id) ON DELETE SET NULL;

ALTER TABLE teacher ADD FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id) ON DELETE CASCADE;
