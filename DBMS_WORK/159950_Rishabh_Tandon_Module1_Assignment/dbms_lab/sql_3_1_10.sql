SELECT s.staff_code, s.staff_name, d.dept_name, des.design_name
 from staff_master s
	join department_master d on s.dept_code = d.dept_code
	join designation_master des on s.design_code = des.design_code
		where months_between(s.hiredate,sysdate) <= 3;