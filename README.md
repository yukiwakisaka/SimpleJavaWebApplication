SimpleJavaWebApplication
===

Requirements
---
- Vagrant >1.9.3
- Mysql >5.x (ex. 5.7)
- JDK 1.7 or 1.8
- Tomcat >7.0.47
- Maven >3.3.9

## Vagrant
```
$ vagrant up; vagrant provision; vagrant reload
```

## MySql
```
$ vagrant ssh
$ grep 'temporary password' /var/log/mysqld.log
... [Note] A temporary password is generated for root@localhost: RI6w?ycfvljV
$ mysql_secure_installation
$ mysql -u root -p
> create database 17training;
> use 17training;
> create table users(ID INT NOT NULL PRIMARY KEY, NAME VARCHAR(20));
> insert users value(0, "YourName");
```

## 実行
```
$ cd /vagrant/
$ mvn -Dmysql.url=jdbc:mysql://localhost:3306/17training -Dmysql.user=root -Dmysql.password=[password] tomcat7:run
`
MySQLのdatabase名、user、passwordは適宜変更してください

## アクセス
 http://localhost:8080

## パッケージング
```
$ mvn package
```
