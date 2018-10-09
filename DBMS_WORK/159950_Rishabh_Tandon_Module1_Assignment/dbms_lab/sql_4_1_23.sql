Create view vAccs_Dtls as (customerCode, AccountHolderName, AccountNumber, Type , Balance)
as select * from Accounts_master 
	where accountType = 'IND' and balance > 10000;