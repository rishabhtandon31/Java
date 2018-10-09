alter table Employee_master
add mobileNo varchar2(15);


alter table Employee_master
add (adhaarNo varchar2(15),
emailId varchar2(15));

insert into Employee_master
(employeeId,firstName,lastName,mobileno)
values(1,'Rishabh','Tandon',79879879);

alter table employee_master
add Constraint pk_empid PRIMARY KEY (employeeId);

DELETE FROM employee_master  
WHERE employeeId = 1;  

insert into Employee_master
values(15,'Vivek','Singla','5435879','545543365','vfdg@gmail.com');  
 
