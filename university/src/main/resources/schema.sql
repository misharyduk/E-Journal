CREATE TABLE IF NOT EXISTS `university`(
    `unversity_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `university_name` VARCHAR(255) NOT NULL,
    `university_description` VARCHAR(255) DEFAULT NULL,
    `address_id` INT DEFAULT NULL,
    `mobile_phone` VARCHAR(255) DEFAULT NULL,
    `email` VARCHAR(255) DEFAULT NULL,
    `accreditation` VARCHAR(255) DEFAULT NULL,
    `rector_id` INT,
    FOREIGN KEY (rector_id) REFERENCES teacher(teacher_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
)

CREATE TABLE IF NOT EXISTS `faculty`(
    `faculty_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `faculty_name` VARCHAR(255) NOT NULL,
    `faculty_description` VARCHAR(255) DEFAULT NULL,
    `address_id` INT DEFAULT NULL,
    `office_number` VARCHAR(255) DEFAULT NULL,
    `mobile_phone` VARCHAR(255) DEFAULT NULL,
    `email` VARCHAR(255) DEFAULT NULL,
    `dean_id` INT,
    `university_id` INT,
    FOREIGN KEY (dean_id) REFERENCES teacher(teacher_id),
    FOREIGN KEY (university_id) REFERENCES university(university_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
)

CREATE TABLE IF NOT EXISTS `department`(
    `department_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `department_name` VARCHAR(255) NOT NULL,
    `department_description` VARCHAR(255) DEFAULT NULL,
    `address_id` INT DEFAULT NULL,
    `office_number` VARCHAR(255) DEFAULT NULL,
    `mobile_phone` VARCHAR(255) DEFAULT NULL,
    `email` VARCHAR(255) DEFAULT NULL,
    `head_of_department_id` INT,
    `faculty_id` INT,
    FOREIGN KEY (ead_of_department_id) REFERENCES teacher(teacher_id),
    FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
)

CREATE TABLE IF NOT EXISTS `teacher`(
    `teacher_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `middle_name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) DEFAULT NULL,
    `mobile_phone` VARCHAR(255) DEFAULT NULL,
    `faculty_id` INT,
    FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id)
)

CREATE TABLE IF NOT EXISTS `subject`(
    `subject_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `subject_name` VARCHAR(255) NOT NULL
)

CREATE TABLE IF NOT EXISTS `address`(
    `address_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `country` VARCHAR(255) NOT NULL,
    `city` VARCHAR(255) NOT NULL,
    `street` VARCHAR(255) NOT NULL,
    `number` VARCHAR(255) NOT NULL,
    `zipCode` VARCHAR(255) NOT NULL
)