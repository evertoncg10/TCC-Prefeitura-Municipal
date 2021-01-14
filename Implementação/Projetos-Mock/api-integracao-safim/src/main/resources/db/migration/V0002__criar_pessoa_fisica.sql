
CREATE TABLE public.pessoa_fisica
(
    id SERIAL,
    email character varying(60) COLLATE pg_catalog."default",
    telefone character varying(11) COLLATE pg_catalog."default" NOT NULL,
    cargo character varying(120) COLLATE pg_catalog."default",
    cpf character varying(11) COLLATE pg_catalog."default" NOT NULL,
    data_nascimento date NOT NULL,
    matricula bigint,
    nome character varying(120) COLLATE pg_catalog."default",
    sexo character varying(1) COLLATE pg_catalog."default" NOT NULL,
    tipo character varying(40) COLLATE pg_catalog."default",
    endereco_id bigint NOT NULL,
    CONSTRAINT pessoa_fisica_pkey PRIMARY KEY (id),
    CONSTRAINT fkmndghl3xolrj6x9pwd40rilim FOREIGN KEY (endereco_id)
        REFERENCES public.endereco (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.pessoa_fisica
    OWNER to postgres;
	
INSERT INTO public.pessoa_fisica (email, telefone, cargo, cpf, data_nascimento, matricula, nome, sexo, tipo, endereco_id) VALUES ('jose_re@hotmail.com', '38999568523', '', '17909085079', '1981-05-20', null::bigint,'José Fernandes da Fonseca', 'M','CIDADAO', 2);
INSERT INTO public.pessoa_fisica (email, telefone, cargo, cpf, data_nascimento, matricula, nome, sexo, tipo, endereco_id) VALUES ('robsonsilva@gmail.com', '38998965412', 'Motorista', '74241459080', '1978-09-10', 0562,'Robson da Silva', 'M','SERVIDOR_PUBLICO', 1);
INSERT INTO public.pessoa_fisica (email, telefone, cargo, cpf, data_nascimento, matricula, nome, sexo, tipo, endereco_id) VALUES ('maria_souza15@hotmail.com', '38997851265', '', '95967938028', '1966-02-05', null::bigint,'Maria de Souza', 'F','CIDADAO', 2);
INSERT INTO public.pessoa_fisica (email, telefone, cargo, cpf, data_nascimento, matricula, nome, sexo, tipo, endereco_id) VALUES ('joana_maria@gmail.com', '38998965412', 'Geólogo', '06368529032', '1971-11-25', 0782,'Joana Maria Silva', 'F','SERVIDOR_PUBLICO', 1);