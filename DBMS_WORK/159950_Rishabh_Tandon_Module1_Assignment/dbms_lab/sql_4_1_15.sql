CREATE TABLE AccountsMaster
(CustomerId number(5),
AccountNumber number(10,2) constraint Acc_PK primary key,
AccountType char(3),
LedgerBalance number(10,2) null 
);