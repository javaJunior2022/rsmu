create sequence students_id_seq1;

alter sequence students_id_seq1 owner to admin;

create table if not exists courses
(
    id         serial
        primary key,
    name       varchar
        unique,
    start_date timestamp with time zone,
    end_date   timestamp with time zone,
    is_active  boolean
);

alter table courses
    owner to admin;

create table if not exists students
(
    id         integer generated always as identity
        primary key
        constraint students_pk
            unique,
    surname    varchar not null,
    name       varchar not null,
    patronymic varchar not null,
    group_name varchar,
    is_active  boolean
);

alter table students
    owner to admin;

alter sequence students_id_seq1 owned by students.id;

create table if not exists "studentAndCourses"
(
    id         serial
        primary key,
    studend_id integer not null
        constraint studend_id
            references students,
    course_id  integer not null
        constraint course_id
            references courses
);

alter table "studentAndCourses"
    owner to admin;

create table if not exists sessions
(
    id         serial
        primary key,
    name       varchar not null,
    start_date timestamp with time zone,
    max_rating integer,
    course_id  integer not null
        constraint course_id
            references courses
);

alter table sessions
    owner to admin;

create table if not exists "sessionsRatings"
(
    id         integer not null
        constraint ratings_pkey
            primary key,
    student_id integer not null
        constraint student_id
            references students,
    session_id integer not null
        constraint session_id
            references sessions,
    rating     integer
);

alter table "sessionsRatings"
    owner to admin;

create table if not exists "coursesRatings"
(
    id         integer not null,
    student_id integer not null
        constraint student_id
            references students,
    course_id  integer not null
        constraint course_id
            references courses,
    rating     integer
);

alter table "coursesRatings"
    owner to admin;

