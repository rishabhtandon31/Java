UPDATE employee
set job = 'Analyst' where empno=7788;


UPDATE employee
set job = (select job from employee where empno=7788),
	deptno=(select deptno from employee where empno=7788)
	where empno=7698;