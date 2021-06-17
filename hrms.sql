-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.candidate_abilities
(
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    candidate_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_educations
(
    id integer NOT NULL,
    department_name character varying(255) NOT NULL,
    finish_year integer,
    school_name character varying(255) NOT NULL,
    start_year integer NOT NULL,
    candidate_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_experiences
(
    id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    finish_date date,
    "position" character varying(255) NOT NULL,
    start_date date NOT NULL,
    candidate_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_languages
(
    id integer NOT NULL,
    level smallint NOT NULL,
    candidate_id integer NOT NULL,
    language_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_pictures
(
    id integer NOT NULL,
    uploaded_date timestamp without time zone NOT NULL,
    picture_url character varying(255) NOT NULL,
    candidate_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_social_medias
(
    id integer NOT NULL,
    link character varying(255) NOT NULL,
    candidate_id integer NOT NULL,
    link_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidates
(
    id integer NOT NULL,
    first_name character varying(35) NOT NULL,
    last_name character varying(35) NOT NULL,
    birth_date date NOT NULL,
    national_identity character varying(255),
    PRIMARY KEY (id)
);

CREATE TABLE public.cities
(
    city_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    city_name character varying(60) NOT NULL,
    PRIMARY KEY (city_id)
);

CREATE TABLE public.employee_confirms
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employee_id integer NOT NULL,
    is_confirmed boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employee_confirms_employers
(
    id integer NOT NULL,
    employer_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employees
(
    id integer NOT NULL,
    first_name character varying(35) NOT NULL,
    last_name character varying(35) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers
(
    id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    web_address character varying(255) NOT NULL,
    phone_number character varying(12) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_positions
(
    job_position_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    title character varying(255),
    PRIMARY KEY (job_position_id)
);

CREATE TABLE public.job_postings
(
    job_posting_id integer NOT NULL,
    application_deadline date NOT NULL,
    city_id integer NOT NULL,
    description character varying(255) NOT NULL,
    job_position_id integer NOT NULL,
    max_salary double precision NOT NULL,
    min_salary double precision NOT NULL,
    number_of_open_position integer NOT NULL,
    employer_id integer NOT NULL,
    creation_date date NOT NULL,
    is_active boolean NOT NULL,
    job_posting_name character varying(255) NOT NULL,
    working_place_type integer,
    working_time_type integer,
    working_time_name integer,
    PRIMARY KEY (job_posting_id)
);

CREATE TABLE public.languages
(
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.link_types
(
    id integer NOT NULL,
    type character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email_address character varying(320) NOT NULL,
    password character varying(25) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.verification_codes
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code character varying(38) NOT NULL,
    is_verified boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.verification_codes_candidates
(
    id integer NOT NULL,
    candidate_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.verification_codes_employers
(
    id integer NOT NULL,
    employer_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.working_place_types
(
    id integer NOT NULL,
    working_place_name character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.working_time_type
(
    id integer NOT NULL,
    working_time_name character varying(255),
    PRIMARY KEY (id)
);

CREATE TABLE public.working_time_types
(
    id integer NOT NULL,
    working_time_name character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.candidate_abilities
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.candidate_educations
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.candidate_experiences
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.candidate_languages
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.candidate_languages
    ADD FOREIGN KEY (language_id)
    REFERENCES public.languages (id)
    NOT VALID;


ALTER TABLE public.candidate_pictures
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.candidate_social_medias
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.candidate_social_medias
    ADD FOREIGN KEY (link_id)
    REFERENCES public.link_types (id)
    NOT VALID;


ALTER TABLE public.candidates
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employee_confirms
    ADD FOREIGN KEY (employee_id)
    REFERENCES public.employees (id)
    NOT VALID;


ALTER TABLE public.employee_confirms_employers
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.employees
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (job_position_id)
    REFERENCES public.job_positions (job_position_id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (working_time_name)
    REFERENCES public.working_place_types (id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cities (city_id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (working_time_name)
    REFERENCES public.working_time_type (id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (working_time_type)
    REFERENCES public.working_time_type (id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (working_place_type)
    REFERENCES public.working_place_types (id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (working_time_type)
    REFERENCES public.working_time_types (id)
    NOT VALID;


ALTER TABLE public.verification_codes_candidates
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.verification_codes_candidates
    ADD FOREIGN KEY (id)
    REFERENCES public.verification_codes (id)
    NOT VALID;


ALTER TABLE public.verification_codes_employers
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.verification_codes_employers
    ADD FOREIGN KEY (id)
    REFERENCES public.verification_codes (id)
    NOT VALID;

END;
