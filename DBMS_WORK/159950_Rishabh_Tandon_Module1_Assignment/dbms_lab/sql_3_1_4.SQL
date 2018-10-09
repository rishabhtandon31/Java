SELECT s.staff_code, s.staff_name, dep.dept_name, 
des.design_name, b.book_code, b.book_name, t.book_issue_date
	from staff_master s 
		join department_master dep on s.dept_code = dep.dept_code
		join designation_master des on s.design_code = des.design_code
		join book_transactions t on s.staff_code = t.staff_code
		join book_master b on b.book_code = t.book_code
			where floor(sysdate - t.book_issue_date) <30 and floor(sysdate - t.book_issue_date) >= 0;