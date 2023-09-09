CREATE TABLE tb_resposta (
	id bigserial NOT NULL,
	data_criacao timestamp(6) NULL,
	texto varchar(3000) NULL,
	aluno_id int8 NULL,
	nota_id int8 NULL,
	tarefa_id int8 NULL,
	CONSTRAINT tb_resposta_pkey PRIMARY KEY (id),
	CONSTRAINT uk_4q4lljrkcim61ktspdlcb4lx8 UNIQUE (nota_id),
	CONSTRAINT fk8917msls2sbs199o187ivpr54 FOREIGN KEY (nota_id) REFERENCES tb_nota(id),
	CONSTRAINT fkiogxip994a17c0835enha1yld FOREIGN KEY (aluno_id) REFERENCES tb_user(id),
	CONSTRAINT fkjr81n9gexc6l9oerl20ihpe5m FOREIGN KEY (tarefa_id) REFERENCES tb_tarefa(id)
);