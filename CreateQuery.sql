create table student (
       studentId integer not null,
        city varchar(255),
        country varchar(255),
        name varchar(255) unique,
        pincode varchar(255),
        score integer not null,
        result varchar(10),
        primary key (studentId)
    );