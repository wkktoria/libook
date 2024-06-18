FROM mysql:latest

RUN chown -R mysql:root /var/lib/mysql/

ADD data.sql /etc/mysql/data.sql

RUN sed -i 's/MYSQL_DATABASE/'$MYSQL_DATABASE'/g' /etc/mysql/data.sql
RUN cp /etc/mysql/data.sql /docker-entrypoint-initdb.d

COPY my.cnf /etc/mysql/conf.d/my.cnf

EXPOSE 3306