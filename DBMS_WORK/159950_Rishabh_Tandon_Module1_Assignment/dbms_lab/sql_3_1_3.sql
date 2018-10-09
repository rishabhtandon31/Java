SELECT s.student_code, s.student_name, t.book_code, b.book_name
	from student_master s, book_master b, book_transactions t
		where s.student_code = t.student_code and b.book_code = t.book_code
			and floor(sysdate - t.book_expected_return_date)=0;