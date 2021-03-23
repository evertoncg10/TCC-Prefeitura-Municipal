-- Table: public.imovel

-- DROP TABLE public.imovel;

CREATE TABLE public.imovel
(
    id serial,
    aliquota double precision NOT NULL,
    area_construida double precision NOT NULL,
    area_total double precision NOT NULL,
    cnpj character varying(14) COLLATE pg_catalog."default",
    cpf character varying(11) COLLATE pg_catalog."default",
    inscricao_municipal character varying(10) COLLATE pg_catalog."default",
    tipo_imovel character varying(255) COLLATE pg_catalog."default",
    tipo_imposto character varying(255) COLLATE pg_catalog."default",
    valor_imovel double precision NOT NULL,
    endereco_id bigint NOT NULL,
    CONSTRAINT imovel_pkey PRIMARY KEY (id),
    CONSTRAINT fkmi88x3yejiwk9c9gh7lhkr3mn FOREIGN KEY (endereco_id)
        REFERENCES public.endereco (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.imovel
    OWNER to postgres;
    
INSERT INTO public.imovel(aliquota, area_construida, area_total, cnpj, cpf, inscricao_municipal, tipo_imovel, tipo_imposto, valor_imovel, endereco_id)
	VALUES (1.0, 45.25, 60.25, '03643487000119', null, '5249786325', 'CASA', 'IPTU', 150000, 1);
INSERT INTO public.imovel(aliquota, area_construida, area_total, cnpj, cpf, inscricao_municipal, tipo_imovel, tipo_imposto, valor_imovel, endereco_id)
	VALUES (0.4, 70, 100, null, '17909085079', '0985632147', 'CASA', 'ITR', 1500000, 2);
INSERT INTO public.imovel(aliquota, area_construida, area_total, cnpj, cpf, inscricao_municipal, tipo_imovel, tipo_imposto, valor_imovel, endereco_id)
	VALUES (1.5, 60.78, 95.41, null, '06368529032', '0023658914', 'APARTAMENTO', 'IPTU', 349999.99, 3);