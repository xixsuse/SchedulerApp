create table user
(
  email     varchar(50) not null
    primary key,
  password  varchar(16) null,
  name      varchar(50) null,
  phone     varchar(11) null,
  birthdate date        null
);

create table appointment
(
  email       varchar(50) not null,
  appdate     date        not null,
  apptime     time        not null,
  category    varchar(50) null,
  event       varchar(50) null,
  description text        null,
  primary key (email, appdate, apptime),
  constraint appointment_user_fk
    foreign key (email) references user (email)
      on update cascade
);

create table reminder
(
  email    varchar(50) not null
    primary key,
  media    varchar(50) null,
  schedule time        null,
  constraint reminder_user_fk
    foreign key (email) references user (email)
      on update cascade
);

create table setting
(
  email            varchar(50) not null
    primary key,
  calendarmode     varchar(5)  null,
  calendarcolor    varchar(7)  null,
  appointmentcolor varchar(7)  null,
  constraint setting_user_fk
    foreign key (email) references user (email)
      on update cascade
);
