# HibernateOneToManyAssociation
Using  Annotation Mapping

This Example will demonstrate One-To-Many Bidirectional association mapping between Department and Employee entities, where
Department is Parent class and Employee is Child class.
One Department can have many Employees and Many employees have only one department.

Example: Department-IT has employees (Anil,Deepak,Priya,Vimal) And 
(Anil,Deepak,Priya and Vimal) has only one department IT.




Department(Parent)<1(one)--------------------------------------------------------------------------------*(M)>-Employee(Child)

RDBMS (MySQL) Tables Script:
----------------------------
#Department
CREATE TABLE `department` (
    `department_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `dept_name` VARCHAR(50) NOT NULL DEFAULT '-NA-',
    PRIMARY KEY (`department_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=115

#Employee
CREATE TABLE `employee` (
    `employee_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NULL DEFAULT NULL,
    `lastname` VARCHAR(50) NULL DEFAULT NULL,
    `birth_date` DATE NULL DEFAULT NULL,
    `cell_phone` VARCHAR(15) NULL DEFAULT NULL,
    `department_id` BIGINT(20) NULL DEFAULT NULL,
    PRIMARY KEY (`employee_id`),
    INDEX `FK_DEPT` (`department_id`),
    CONSTRAINT `FK_DEPT` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
