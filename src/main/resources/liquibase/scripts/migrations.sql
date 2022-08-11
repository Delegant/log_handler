-- liquibase formatted sql

-- changeset tony:1

create table student
(
    id   SERIAL       NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL
);

-- changeset tony:2

INSERT INTO student(name)
VALUES ('Ольга Макеева'),
       ('Ольга Соловьева'),
       ('Полина Стефанская'),
       ('Евгений Ильин'),
       ('Алексей Кузнецов'),
       ('Даниль Адигамов'),
       ('Юлия Суслова'),
       ('Максим Ростиславский'),
       ('Эдуард Гайниев'),
       ('Юрий Иванов'),
       ('Иван Моря'),
       ('Роман Головачев'),
       ('Игорь Зубров'),
       ('Антон Кадачигов'),
       ('Андрей Булавин'),
       ('Максим Маковеев'),
       ('Евгений Юруть'),
       ('Арсений Виноградов'),
       ('Александр Варкан'),
       ('Олег Гвоздь');

-- changeset tony:3

create table log
(
    id         SERIAL       PRIMARY KEY,
    text       varchar(255) NOT NULL,
    dataTime   timestamp    NOT NULL,
    student_id bigint       NOT NULL
        CONSTRAINT student_logs REFERENCES student (id)
);

-- changeset tony:4

ALTER TABLE log
RENAME COLUMN datatime TO data_time

