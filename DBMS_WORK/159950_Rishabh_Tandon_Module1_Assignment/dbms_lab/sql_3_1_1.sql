INSERT INTO DEPARTMENT_MASTER
values(111,'JAVA FULL STACK');
INSERT INTO DEPARTMENT_MASTER
values(222,'Big DATA');


SELECT s.staff_name,s.dept_code,d.dept_name
	from staff_master s, department_master d
	where s.dept_code = d.dept_code;
	
	
SELECT s.staff_name,s.dept_code,d.dept_name
	from staff_master s
	join department_master d on s.dept_code = d.dept_code;
	
