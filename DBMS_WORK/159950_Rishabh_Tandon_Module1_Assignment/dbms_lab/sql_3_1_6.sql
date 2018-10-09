SELECT staff_code, staff_name , staff_sal from staff_master
where staff_sal < (SELECT avg(staff_sal) from staff_master);