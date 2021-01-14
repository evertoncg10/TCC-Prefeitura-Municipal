CREATE TABLE public.pessoa_juridica
(
    id SERIAL,
    email character varying(60) COLLATE pg_catalog."default",
    telefone character varying(11) COLLATE pg_catalog."default" NOT NULL,
    inscricao_estadual character varying(120) COLLATE pg_catalog."default",
    cnpj character varying(14) COLLATE pg_catalog."default" NOT NULL,
    nome_fantasia character varying(120) COLLATE pg_catalog."default",
    razao_social character varying(120) COLLATE pg_catalog."default",
    endereco_id bigint NOT NULL,
    CONSTRAINT pessoa_juridica_pkey PRIMARY KEY (id),
    CONSTRAINT fkip7vkxsxxoxc2osb6y42oxc4w FOREIGN KEY (endereco_id)
        REFERENCES public.endereco (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.pessoa_juridica
    OWNER to postgres;
    
INSERT INTO public.pessoa_juridica (email, telefone, inscricao_estadual, cnpj, nome_fantasia, razao_social, endereco_id) VALUES ('atendimento@dtzone.com.br', '3833556985', '216.625.113/3001', '03643487000119','DTZone Informática LTDA','DTZone Informática', 1);
INSERT INTO public.pessoa_juridica (email, telefone, inscricao_estadual, cnpj, nome_fantasia, razao_social, endereco_id) VALUES ('contato@bomdestinomalhas.com.br', '3833698574', '325.445.112/3001', '44699469000136', 'Bom Destino Malhas', 'RTZ Malhas LTDA', 3);