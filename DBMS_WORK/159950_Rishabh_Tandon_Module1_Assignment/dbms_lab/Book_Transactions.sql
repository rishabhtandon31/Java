CREATE TABLE Book_Transactions
(
	book_code number,
	student_code number,
	staff_code number,
	book_issue_date date not null,
	book_expected_return_date date not null,
	book_actual_return_date date 
);



INSERT INTO Book_Transactions
values(131,11,2016,to_date('11-12-2017','DD-MM-YYYY'),sysdate,sysdate);
INSERT INTO Book_Transactions
values(122,12,1016,to_date('11-01-2017','DD-MM-YYYY'),sysdate,sysdate);
INSERT INTO Book_Transactions
values(123,18,26,to_date('11-06-2017','DD-MM-YYYY'),sysdate,sysdate);
