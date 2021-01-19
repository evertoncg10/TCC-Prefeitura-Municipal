-- Table: public.endereco

-- DROP TABLE public.endereco;

CREATE TABLE public.endereco
(
    id serial,
    bairro character varying(100) COLLATE pg_catalog."default",
    cep character varying(8) COLLATE pg_catalog."default",
    cidade character varying(100) COLLATE pg_catalog."default",
    estado character varying(2) COLLATE pg_catalog."default" NOT NULL,
    logradouro character varying(255) COLLATE pg_catalog."default",
    numero integer,
    CONSTRAINT endereco_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.endereco
    OWNER to postgres;
    
INSERT INTO public.endereco (bairro, cep, cidade, estado, logradouro, numero) VALUES ('Canela', '89562600', 'Bom Destino', 'MG', 'Rud Dr Pedro da Fonseca', 365);
INSERT INTO public.endereco (bairro, cep, cidade, estado, logradouro, numero) VALUES ('Jardim Eldorado', '89555300', 'Bom Destino', 'MG', 'Rua Xavier da Silva', 568);
INSERT INTO public.endereco (bairro, cep, cidade, estado, logradouro, numero) VALUES ('Centro', '89845200', 'Bom Destino', 'MG', 'XV de Novembro', 5623);