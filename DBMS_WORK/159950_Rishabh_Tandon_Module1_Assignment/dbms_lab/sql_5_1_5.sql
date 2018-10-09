UPDATE  employee
set deptno = (select deptno from employee where empno=7698) where empno= 7788;