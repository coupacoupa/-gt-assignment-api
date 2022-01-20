# Feedback Submission API

A back-end project created with springboot to accept submission and retrieve submissions.

Swagger URL: http://localhost:8080/swagger-ui/#/

## Run local profile (default profile)
```text
Execute bootRun
```

## MySql Setup (prod profile)

```bash
# login with account with privilege
mysql -u root -p

# create database
create database govtechassignment;
show databases;

# create user
create user 'assignmentuser'@localhost identified  by 'root';
select User from mysql.user;

# provide permission
grant all privileges on govtechassignment.* to 'assignmentuser'@localhost;
flush privileges;
show grants for 'assignmentuser'@localhost;
```

## Run local profile (prod profile)
```text
Execute bootRun with SPRING_PROFILES_ACTIVE=prod
```
