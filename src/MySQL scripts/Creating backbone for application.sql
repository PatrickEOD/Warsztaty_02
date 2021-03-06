use programmingSchool;
CREATE TABLE users(
id BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
username VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
password VARCHAR(245) NOT NULL,
person_group_id INT(11),
FOREIGN KEY (person_group_id) REFERENCES user_group(id)
);
CREATE TABLE user_group(
id INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
name VARCHAR(255) NOT NULL
);
CREATE TABLE solution(
id INT(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
created DATETIME NOT NULL,
updated DATETIME,
description TEXT,
excercise_id INT(11) NOT NULL,
users_id BIGiNT(20) NOT NULL,
FOREIGN KEY (users_id) REFERENCES users(id),
FOREIGN KEY (excercise_id) REFERENCES excercise(id)
);
CREATE TABLE excercise(
id INT(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
description TEXT
);