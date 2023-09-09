CREATE TABLE tb_tarefa (
	id bigserial NOT NULL,
	criado_em timestamp(6) NULL,
	fim timestamp(6) NULL,
	inicio timestamp(6) NULL,
	proposta varchar(1300) NULL,
	titulo varchar(200) NULL,
	disciplina_id int8 NULL,
	professor_id int8 NULL,
	turma_id int8 NULL,
	CONSTRAINT tb_tarefa_pkey PRIMARY KEY (id),
	CONSTRAINT fk29l9p4fs64u6xhy3f5m8qpfxx FOREIGN KEY (disciplina_id) REFERENCES tb_disciplina(id),
	CONSTRAINT fk32ug7phbvsgpqrf4eqk60lo3t FOREIGN KEY (professor_id) REFERENCES tb_user(id),
	CONSTRAINT fkjlaeufu7o8gkbspy29mg73022 FOREIGN KEY (turma_id) REFERENCES tb_turma(id)
);