SELECT d.dept_code,d.dept_name, NVL2(count(s.staff_code),count(s.staff_code),0)+ NVL2(count(st.student_code),count(st.student_code),0)
from department_master d
	left join staff_master s on d.dept_code = s.staff_master
	left join student_master st on d.dept_code = st.student_master
	group by d.dept_name, d.dept_code;