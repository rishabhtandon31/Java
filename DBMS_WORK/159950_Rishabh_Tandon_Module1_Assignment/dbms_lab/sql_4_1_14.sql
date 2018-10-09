DROP table suppliers;

CREATE TABLE CustomerMaster
(CustomerId number(5) constraint CustId_PK Primary Key,
CustomerName varchar(20) NOT NULL,
Address1 varchar2(30) NOT NULL,
Address2 varchar2(30),
Gender varchar2(1),
Age number(3),
Phoneno number(10)
);