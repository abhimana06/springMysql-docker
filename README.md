# springMysql-docker

Containrized Spring boot application with basic CRUD operations using Docker.

Connected to 'mysql/mysql-docker' container (https://github.com/mysql/mysql-docker/blob/mysql-server/8.0/Dockerfile)  for MySQL database connection for Mac M1.

# # Command to create MySQL container 

--> docker run -d -p 3306:3306 --name mysql-docker --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_ROOT_USERNAME=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=demo" mysql/mysql-server

Command to build and run the springMysql-docker

-->  docker build -f Dockerfile  -t springmysql-dock .

-->  docker run -t --name springmysql-dock --link mysql-docker:mysql -p 8086:8086 springmysql-dock

Need to execute below commands after MySQL container created (Mac )

docker exec -it <mysql-container> /bin/bash/
bash# mysql -uroot -uroot

mysql> select user,host from mysql.user;
mysql> GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION;
mysql> Flush privileges

