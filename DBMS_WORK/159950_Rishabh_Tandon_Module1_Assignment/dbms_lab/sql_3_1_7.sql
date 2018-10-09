SELECT book_pub_author, book_name from book_master
	where book_pub_author= (SELECT book_pub_author from 
							book_master group by book_pub_author
							having count(*) > 1);