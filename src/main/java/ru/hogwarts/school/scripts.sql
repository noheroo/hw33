select *
from student;

select*
from student
where age > 10
  and age < 20;

select name
from student;

select *
from student
where name like '%s%';

select *
from student
where student.age < student.id;

select*
from student
order by age;