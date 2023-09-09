CREATE TABLE tb_user (
	tipo_user varchar(31) NOT NULL,
	id bigserial NOT NULL,
	cpf varchar(255) NULL,
	data_nascimento date NULL,
	email varchar(255) NULL,
	genero varchar(255) NULL,
	nome varchar(50) NULL,
	numero_telefone varchar(9) NULL,
	senha varchar(50) NULL,
	sobrenome varchar(50) NULL,
	turma_id int8 NULL,
	CONSTRAINT tb_user_genero_check CHECK (((genero)::text = ANY ((ARRAY['MASCULINO'::character varying, 'FEMININO'::character varying, 'OUTRO'::character varying])::text[]))),
	CONSTRAINT tb_user_pkey PRIMARY KEY (id),
	CONSTRAINT fk39f1fub2y2rrieyw6s4yhdy3c FOREIGN KEY (turma_id) REFERENCES tb_turma(id)
);