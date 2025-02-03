create table users (
    username varchar2(50) primary key,
    full_name varchar2(100),
    password varchar2(100) not null,
    gender varchar2(10),
    phone varchar2(15),
    balance number(10,2),
    dob date
);

insert into users values ('mohamed', 'Mohamed Ashraf', '123', 'male', '1234567890', 100.50, to_date('1995-04-15', 'yyyy-mm-dd'));
insert into users values ('omar', 'Omar Alaaden', 'pass123', 'male', '1234567890', 250.50, to_date('1992-08-21', 'yyyy-mm-dd'));
insert into users values ('menna','Mennatullah', '123456', 'female', '1234567890', 150.50, to_date('1999-08-19', 'yyyy-mm-dd'));
insert into users values ('somaya', 'Somaya Ahmed', '123456', 'female', '1234567890', 100.50, to_date('2000-06-17', 'yyyy-mm-dd'));
insert into users values ('jane_smith', 'jane smith', 'securepass', 'female', '9876543210', 250.75, to_date('1992-08-21', 'yyyy-mm-dd'));
insert into users values ('alex_brown', 'alex brown', 'alexpass', 'male', '4561237890', 500.00, to_date('1989-12-05', 'yyyy-mm-dd'));
insert into users values ('emma_white', 'emma white', 'whitesecure', 'female', '7418529630', 300.25, to_date('2000-06-30', 'yyyy-mm-dd'));
insert into users values ('michael_lee', 'michael lee', 'mikepass', 'male', '8523697410', 120.00, to_date('1985-03-12', 'yyyy-mm-dd'));
insert into users values ('sophia_clark', 'sophia clark', 'sophiasec', 'female', '3692581470', 600.90, to_date('1997-11-25', 'yyyy-mm-dd'));
insert into users values ('william_hall', 'william hall', 'hallpass', 'male', '1597534862', 80.00, to_date('1993-09-14', 'yyyy-mm-dd'));
insert into users values ('olivia_walker', 'olivia walker', 'olivia123', 'female', '7539514562', 450.60, to_date('1990-02-28', 'yyyy-mm-dd'));
insert into users values ('david_adams', 'david adams', 'davidpass', 'male', '3216549870', 210.40, to_date('1988-07-19', 'yyyy-mm-dd'));
insert into users values ('mia_johnson', 'mia johnson', 'miasecure', 'female', '4567891230', 700.00, to_date('1996-05-07', 'yyyy-mm-dd'));
commit;


create table notifications(
notification_id number(5) primary key,
receiver_name varchar2(50) not null,
notification_content varchar2(100)  not null,
notification_date date,
constraint user_notification_fk foreign key (receiver_name) references users(username) 
);

