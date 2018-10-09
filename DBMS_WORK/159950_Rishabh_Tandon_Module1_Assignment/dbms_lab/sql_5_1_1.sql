CREATE TABLE employee
(
	empno number(4) not null,
	ename varchar2(10),
	job varchar2(50),
	mgr number(4),
	hiredate date,
	sal number(7,2),
	comm number(7,2),
	deptno number(2)
);