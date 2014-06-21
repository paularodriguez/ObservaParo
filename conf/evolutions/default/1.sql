# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table acobservation (
  id                        bigint not null,
  autonomous_community_id   varchar(255),
  autonomous_community_name varchar(255),
  total_value               integer,
  total_value_men           integer,
  total_value_women         integer,
  total_value_under25       integer,
  value_men_under25         integer,
  value_women_under25       integer,
  total_value_over25        integer,
  value_men_over25          integer,
  value_women_over25        integer,
  constraint pk_acobservation primary key (id))
;

create table autonomous_community (
  id                        varchar(255) not null,
  name                      varchar(255) not null)
;

create table historic_observation (
  id                        bigint not null,
  obs_value                 double,
  year                      integer,
  month                     varchar(255),
  agriculture_sector        double,
  industry_sector           double,
  building_sector           double,
  services_sector           double,
  without_employ            double,
  constraint pk_historic_observation primary key (id))
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
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_province primary key (id))
;

create table province_observation (
  id                        bigint not null,
  province_id               varchar(255),
  total_value               integer,
  total_value_men           integer,
  total_value_women         integer,
  total_value_under25       integer,
  value_men_under25         integer,
  value_women_under25       integer,
  total_value_over25        integer,
  value_men_over25          integer,
  value_women_over25        integer,
  constraint pk_province_observation primary key (id))
;

create sequence acobservation_seq;

create sequence autonomous_community_seq;

create sequence historic_observation_seq;

create sequence observation_seq;

create sequence province_seq;

create sequence province_observation_seq;

alter table acobservation add constraint fk_acobservation_autonomousCom_1 foreign key (autonomous_community_id,autonomous_community_name) references autonomous_community (id,name) on delete restrict on update restrict;
create index ix_acobservation_autonomousCom_1 on acobservation (autonomous_community_id,autonomous_community_name);
alter table province_observation add constraint fk_province_observation_provin_2 foreign key (province_id) references province (id) on delete restrict on update restrict;
create index ix_province_observation_provin_2 on province_observation (province_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists acobservation;

drop table if exists autonomous_community;

drop table if exists historic_observation;

drop table if exists observation;

drop table if exists province;

drop table if exists province_observation;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists acobservation_seq;

drop sequence if exists autonomous_community_seq;

drop sequence if exists historic_observation_seq;

drop sequence if exists observation_seq;

drop sequence if exists province_seq;

drop sequence if exists province_observation_seq;

