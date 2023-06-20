-- INSERT INTO users VALUES ('ROLE_ADMIN');
create table PUBLIC.users (
  id int PRIMARY KEY,
  name varchar(50),
  username varchar(50),
  email varchar(100),
  password varchar(100)
);