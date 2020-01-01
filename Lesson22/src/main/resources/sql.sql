select first_second_name as Avg_count from student.students where id_student = 5
union
select avg(point_st)  from points where id_student = 5;