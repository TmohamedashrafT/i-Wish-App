create table notifications(
notification_id number(5) primary key,
receiver_name varchar2(50) not null,
notification_content varchar2(100)  not null,
notification_date date,
constraint user_notification_fk foreign key (receiver_name) references users(username) 
);

create sequence notifications_seq
            start with 1
            maxvalue 9999
            nocycle;

create or replace trigger notifications_trg
before insert on notifications 
for each row
begin
        :new.notification_id := notifications_seq.nextval;
end notifications_trg;

show errors;

