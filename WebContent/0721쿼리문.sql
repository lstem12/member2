create table grade(
grd_no number(2,0) not null primary key,
grd_name varchar2(20) not null,
grd_desc varchar2(400)
);

create table employee(
emp_no number(4,0) not null primary key,
emp_name varchar2(30) not null,
emp_credat date not null,
emp_salary number(9,0) default 0,
grd_no number(2,0) default 1,
emp_active char(1) default 1,
constraint fk_grade_grd_no foreign key (grd_no)
REFERENCES grade(grd_no)
);

select * from employee;

select * from employee
where grd_no=(
select min(grd_no) from employee 
where emp_salary>(select avg(emp_salary) from employee));

select grd_no, count(1) from employee
group by grd_no
;

select g.grd_name,count(1),avg(e.emp_salary),sum(e.emp_salary),
min(e.emp_salary) from grade g, employee e
where g.grd_no=e.grd_no
group by g.grd_name
;

select count(*), min(emp_salary),max(emp_salary),sum(emp_salary),avg(emp_salary) from employee;

update employee
set emp_salary = emp_salary/10;

commit;