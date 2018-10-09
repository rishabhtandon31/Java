SELECT * from book_master b
	join book_transactions t on b.book_code = t.book_code
	where t.book_actual_return_date is NULL and
		ceil(t.book_actual_return_date - next_day(sysdate - 7, 'MONDAY'))=0;