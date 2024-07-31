create database session13_01;
use session13_01;

create table Classes (
    ClassId varchar(15) not null primary key ,
    ClassName varchar(15) not null unique,
    status bit
);

create table Students (
    StudentId int auto_increment primary key ,
    fullName varchar(50),
    Gender bit,
    Birthday datetime,
    Address varchar(200),
    ClassId varchar(15),
    foreign key (ClassId) references Classes(ClassId)
);

delimiter $$
create procedure get_all_students()
begin
    select s.*,c.className from Students s inner join Classes c on s.classId= c.classId;
end $$;

delimiter $$
create procedure insert_student(
    fullName_in varchar(50),
    gender_in bit,
    birthday_in datetime,
    address_in varchar(200),
    classId_in varchar(15)
)
begin
    insert into Students(fullName,gender,birthday,address,classId) value (fullName_in,gender_in,birthday_in,address_in,classId_in);
end $$;

delimiter $$
create procedure update_student(
    stuId_in int,
    fullName_in varchar(50),
    gender_in bit,
    birthday_in datetime,
    address_in varchar(200),
    classId_in varchar(15)
)
begin
    update Students set fullName=fullName_in,gender =gender_in,birthday=birthday_in,address=address_in,classId=classId_in where StudentId = stuId_in;
end $$;

delimiter $$
create procedure delete_student(stuId_in int)
begin
    delete from Students where StudentId = stuId_in;
end $$;


delimiter $$
create procedure get_student_by_id(stuId_in int)
begin
    select s.*,c.className from Students s inner join Classes c on s.classId = c.classId where StudentId=stuId_in;
end $$;


create
    definer = root@localhost procedure get_student_by_name(IN stuName_in varchar(50))
BEGIN
    IF stuName_in = '' THEN
        SELECT s.*, c.className
        FROM Students s
                 INNER JOIN Classes c ON s.classId = c.classId;
    ELSE
        SELECT s.*, c.className
        FROM Students s
                 INNER JOIN Classes c ON s.classId = c.classId
        WHERE s.fullName LIKE CONCAT('%', stuName_in, '%');
    END IF;
END;