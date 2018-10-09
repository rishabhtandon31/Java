CREATE SEQUENCE Seq_Emp
start with 1001
increment by 11
minvalue 1000
maxvalue 2000
cache 16;

update emp
set empno = Seq_Emp.nextval;