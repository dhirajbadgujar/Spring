CREATE TABLE EMPLOYEE(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`joining_date` DATE NOT NULL,
	`salary` DOUBLE NOT NULL,
	PRIMARY KEY(id)
)

INSERT INTO employee(`name`, `joining_date`, `salary`) VALUES ('dhiraj', '2001-01-01', 56000.00);

INSERT INTO employee(`name`, `joining_date`, `salary`) VALUES ('sai', '2005-11-10', 40000.00);
INSERT INTO employee(`name`, `joining_date`, `salary`) VALUES ('sharad', '2007-02-02', 60000.00);

INSERT INTO employee(`name`, `joining_date`, `salary`) VALUES ('chhaya', '2010-02-02', 90080.10);