INSERT INTO `ems`.`employee_details`
(`First_Name`,`Last_Name`,`Department`,`Username`,`Password`)
VALUES
('Danindu','Srinath','IT','danindu','12345');

SELECT count(1) FROM `ems`.`employee_details`WHERE Username = 'danindu' and Password = '12345';

INSERT INTO `ems`.`employee_details`
(`First_Name`,`Last_Name`,`Department`,`Username`,`Password`)
VALUES
(?,?,?,?,?);

SELECT`First_Name`,`Last_Name`  FROM `ems`.`employee_details` WHERE Username like 'danindu' AND Password like '12345';
SELECT`Last_Name` FROM `ems`.`employee_details` WHERE Username = 'danindu' AND Password = '12345';

select * from `ems`.`employee_details`;

DELETE FROM `ems`.`employee_details`
WHERE ID>=53;
