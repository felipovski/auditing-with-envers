FROM mysql:8.0

COPY init.sql /docker-entrypoint-initdb.d/init.sql

ENV MYSQL_PASSWORD=test
ENV MYSQL_USERNAME=test
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=audit_db
ENV MYSQL_ALLOW_EMPTY_PASSWORD=yes

CMD ["mysqld", "--default-authentication-plugin=mysql_native_password", "--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci"]

EXPOSE 3306
