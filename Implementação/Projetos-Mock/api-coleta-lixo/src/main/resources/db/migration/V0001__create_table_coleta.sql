CREATE TABLE public.coleta
(
    id SERIAL,
    localidade character varying(255) COLLATE pg_catalog."default",
    frequencia character varying(200) COLLATE pg_catalog."default",
    periodo character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT endereco_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.coleta
    OWNER to postgres;