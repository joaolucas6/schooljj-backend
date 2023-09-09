CREATE TABLE tb_disciplina (
	id bigserial NOT NULL,
	descricao varchar(500) NULL,
	nome varchar(35) NULL,
	CONSTRAINT tb_disciplina_pkey PRIMARY KEY (id)
);