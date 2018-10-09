CREATE TABLE BankDetails
	(
		associateId number(10) NOT NULL,
		accountNumber number, 
		bankName varchar(10) NOT NULL, 
		ifscCode varchar(10) NOT NULL, 
		PRIMARY KEY (accountNumber)
	);
	
INSERT ALL 
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		1112223334441, 'HDFC', 112233
	)
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		1112223334442, 'HDFC', 112233
	)
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		11122233344413, 'ICICI', 1122333
	)
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		11122233344414, 'HDFC', 112233
	)
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		11122233344415, 'STDCHARTED', 112233
	)
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		11122233344416, 'HDFC', 112233
	)
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		11122233344417, 'ICICI', 1122333
	)
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		11122233344418, 'HDFC', 112233
	)
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		11122233344419, 'ICICI', 1122333
	)
	INTO BankDetails(accountNumber,bankName,ifscCode) values
	(
		11122233344420, 'ICICI', 1122333
	)
	select * from dual;