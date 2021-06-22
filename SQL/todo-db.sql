-- Table: public.user_detail

-- DROP TABLE public.user_detail;

CREATE TABLE public.user_detail
(
    user_id bigint NOT NULL DEFAULT nextval('user_detail_user_id_seq'::regclass),
    first_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_user_id PRIMARY KEY (user_id)
)

TABLESPACE pg_default;

ALTER TABLE public.user_detail
    OWNER to postgres;