Create sequence seq_dept
start with 40
increment by 10
minvalue 40
maxvalue 200
cache 16;

update department_master
	set dept_code = seq_dept.nextval;