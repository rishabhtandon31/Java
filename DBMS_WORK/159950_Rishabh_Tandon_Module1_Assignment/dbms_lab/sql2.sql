SELECT staff_code, staff_name, dept_code from staff_master
where trunc(months_between(sysdate , hiredate))/12>18 order by trunc(months_between(sysdate , hiredate))/12;

define count1 = 'trunc(months_between(sysdate , hiredate)/12)';
SELECT staff_code, staff_name, dept_code from staff_master  
where &&count1>18 order by &&count1;