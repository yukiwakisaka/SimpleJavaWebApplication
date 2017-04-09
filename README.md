# SimpleJavaWebApplication
## MySql
```
> create database 17training;
> use 17training;
> create table users(ID INT, NAME VARCHAR(20));
> insert users value(1, "YourName");
```

## 環境変数
` export MYSQL_URL=jdbc:mysql://localhost:3306/17training?user=root&password= `

## 実行
`mvn tomcat7:exec`

## パッケージング
`mvn package`
