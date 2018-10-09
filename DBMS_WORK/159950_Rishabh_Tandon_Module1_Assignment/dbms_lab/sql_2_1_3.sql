SELECT staff_name, round(months_between(sysdate,hiredate)) as "months Worked" from Staff_master
order by months_between(sysdate,hiredate);