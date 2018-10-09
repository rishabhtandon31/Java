ALTER TABLE AccountMaster 
add constraint cust_acc Foriegn Key (customerId) references CustomerMaster(customerId);