# SimpleJavaWebApplication
## MySql
```
> create database 17training;
> use 17training;
> create table users(ID INT NOT NULL PRIMARY KEY, NAME VARCHAR(20));
> insert users value(0, "YourName");
```

## 実行
`mvn -Dmysql.url=jdbc:mysql://localhost:3306/17training -Dmysql.user=root -Dmysql.password= tomcat7:run`
MySQLのdatabase名、user、passwordは適宜変更してください

## パッケージング
`mvn package`
