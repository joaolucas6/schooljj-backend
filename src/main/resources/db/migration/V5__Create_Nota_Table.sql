CREATE TABLE tb_nota (
	id bigserial NOT NULL,
	data_criacao timestamp(6) NULL,
	nota float8 NULL,
	observacoes varchar(3000) NULL,
	professor_id int8 NULL,
	CONSTRAINT tb_nota_pkey PRIMARY KEY (id),
	CONSTRAINT fks5e9wsysg7e3onfgwsdxuxb6p FOREIGN KEY (professor_id) REFERENCES tb_user(id)
);