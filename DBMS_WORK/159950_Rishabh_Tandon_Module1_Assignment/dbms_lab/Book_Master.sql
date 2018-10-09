CREATE TABLE Book_Master
(
	book_code number(10) not null,
	book_name varchar2(50) not null,
	book_pub_year number,
	book_pub_author varchar2(50) not null
);


INSERT INTO Book_Master
values(121,'DS',2016,'JW');

INSERT INTO Book_Master
values(122,'C++',2016,'BS');
INSERT INTO Book_Master
values(123,'NETWORKS',2016,'NS');
