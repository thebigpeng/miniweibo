FROM mysql/mysql-server:8.0.29

MAINTAINER lengleng(wangiegie@gmail.com)

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./miniweibo.sql /docker-entrypoint-initdb.d

COPY ./miniweibo_codegen.sql /docker-entrypoint-initdb.d

COPY ./miniweibo_config.sql /docker-entrypoint-initdb.d

COPY ./miniweibo_job.sql /docker-entrypoint-initdb.d
