CREATE SEQUENCE university_id_sequence INCREMENT BY 1;
CREATE SEQUENCE faculty_id_sequence INCREMENT BY 1;
CREATE SEQUENCE department_id_sequence INCREMENT BY 1;
CREATE SEQUENCE subject_id_sequence INCREMENT BY 1;
CREATE SEQUENCE teacher_id_sequence INCREMENT BY 1;
CREATE SEQUENCE address_id_sequence INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS university(
    university_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    university_name VARCHAR(255) NOT NULL,
    university_description CLOB(2K) DEFAULT NULL,
    address_id BIGINT DEFAULT NULL,
    mobile_phone VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    accreditation VARCHAR(255) DEFAULT NULL,
    rector_id BIGINT
);

CREATE TABLE IF NOT EXISTS faculty(
    faculty_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    faculty_name VARCHAR(255) NOT NULL,
    faculty_description CLOB(2K) DEFAULT NULL,
    address_id BIGINT DEFAULT NULL,
    office_number VARCHAR(255) DEFAULT NULL,
    mobile_phone VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    dean_id BIGINT,
    university_id BIGINT
);

CREATE TABLE IF NOT EXISTS department(
    department_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(255) NOT NULL,
    department_description CLOB(2K) DEFAULT NULL,
    address_id BIGINT DEFAULT NULL,
    office_number VARCHAR(255) DEFAULT NULL,
    mobile_phone VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    head_of_department_id BIGINT,
    faculty_id BIGINT
);

CREATE TABLE IF NOT EXISTS teacher(
    teacher_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) DEFAULT NULL,
    mobile_phone VARCHAR(255) DEFAULT NULL,
    faculty_id BIGINT
);

CREATE TABLE IF NOT EXISTS subject(
    subject_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    subject_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS address(
    address_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL,
    zip_code VARCHAR(255) NOT NULL
);

ALTER TABLE university ADD FOREIGN KEY (rector_id) REFERENCES teacher(teacher_id);
ALTER TABLE university ADD FOREIGN KEY (address_id) REFERENCES address(address_id);


ALTER TABLE faculty ADD FOREIGN KEY (dean_id) REFERENCES teacher(teacher_id);
ALTER TABLE faculty ADD FOREIGN KEY (university_id) REFERENCES university(university_id);
ALTER TABLE faculty ADD FOREIGN KEY (address_id) REFERENCES address(address_id);

ALTER TABLE department ADD FOREIGN KEY (head_of_department_id) REFERENCES teacher(teacher_id);
ALTER TABLE department ADD FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id);
ALTER TABLE department ADD FOREIGN KEY (address_id) REFERENCES address(address_id);

ALTER TABLE teacher ADD FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id)
