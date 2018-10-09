ALTER Table AccountsMaster
drop constraint cust_acc;

ALTER Table AccountsMaster
add constraint cust_acc Foriegn Key (customerid) references customerMaster(customerId) on delete cascade;