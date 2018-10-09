ALTER TABLE AccountMaster 
add constraint at_check check (AccountType in ('NRI','IND')); 