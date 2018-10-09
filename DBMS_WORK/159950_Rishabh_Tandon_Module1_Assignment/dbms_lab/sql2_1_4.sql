define date1= "trim(to_char(hiredate,'DD'))";
define month1= "trim(to_char(hiredate,'MM'))";
select * from staff_master
where &&date1 < 16 and &&month1 = 12;