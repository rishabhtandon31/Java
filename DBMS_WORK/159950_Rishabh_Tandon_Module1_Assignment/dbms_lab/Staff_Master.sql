CREATE TABLE Staff_Master
(
	staff_code number(8) not null,
	staff_name varchar2(50) not null,
	design_code number,
	dept_code number,
	hireDate date,
	staff_dob date,
	staff_address varchar2(240),
	mgr_code number(8),
	staff_sal number(10,2)
);

INSERT INTO staff_master
values(131,'Sahil',2016,22,to_date('11-12-2017','DD-MM-YYYY'),sysdate,
'hijewadi',1122,100000);