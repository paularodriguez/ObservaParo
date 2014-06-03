# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table autonomous_community (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_autonomous_community primary key (id))
;

create table observation (
  id                        bigint not null,
  obs_value                 double,
  month                     varchar(255),
  agriculture_sector        double,
  industry_sector           double,
  building_sector           double,
  services_sector           double,
  without_employ            double,
  autonomous_community      varchar(255),
  province                  varchar(255),
  constraint pk_observation primary key (id))
;

create table province (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_province primary key (id))
;

create sequence autonomous_community_seq;

create sequence observation_seq;

create sequence province_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists autonomous_community;

drop table if exists observation;

drop table if exists province;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists autonomous_community_seq;

drop sequence if exists observation_seq;

drop sequence if exists province_seq;

