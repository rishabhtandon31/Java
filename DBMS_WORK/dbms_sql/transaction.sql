CREATE TABLE Transaction
	(
		transactionId varchar2(15),
		timeStamp date,
		amount number,
		transactionType varchar2(10),
		transactionLocation varchar2(15),
		modeOfTransaction varchar2(15),
		transactionStatus varchar2(15),
		PRIMARY KEY (transactionId)
	);
	
	
	
	
INSERT ALL 
	INTO Transaction VALUES
	(
		'1122',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	INTO Transaction VALUES
	(
		'11221',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	INTO Transaction VALUES
	(
		'112212',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	INTO Transaction VALUES
	(
		'112213',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	INTO Transaction VALUES
	(
		'112214',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	INTO Transaction VALUES
	(
		'112215',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	INTO Transaction VALUES
	(
		'112216',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	INTO Transaction VALUES
	(
		'112217',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	INTO Transaction VALUES
	(
		'112218',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	INTO Transaction VALUES
	(
		'112219',TO_TIMESTAMP('12:12:29' , 'HH24:MI:SS'),5000,'Debit','Delhi','Cash','OK'
	)
	select * from dual;
