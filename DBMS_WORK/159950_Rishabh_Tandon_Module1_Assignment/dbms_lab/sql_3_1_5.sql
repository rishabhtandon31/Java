SELECT s.staff_code, s.staff_name, des.design_name, dep.dept_name, b.book_code, b.book_name
b.book_pub_author, floor(t.book_expected_return_date - sysdate)
from staff_master s
	join designation_master des on s.design_code = des.design_code
	join department_master dep on s.dept_code = dep.dept_code
	join book_master b on t.book_code = b.book_code
	join staff_master s on s.staff_name = t.staff_code
	where b.book_actual_return_date is null and t.book_expected_return_date - sysdate < -1;