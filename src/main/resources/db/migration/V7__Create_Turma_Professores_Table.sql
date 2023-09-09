CREATE TABLE turma_professores (
	turma_id int8 NOT NULL,
	professor_id int8 NOT NULL,
	CONSTRAINT fkj25565u5v97cnmvw03vdqv52i FOREIGN KEY (professor_id) REFERENCES tb_user(id),
	CONSTRAINT fktl7l8rfjy1psshtuhk4tpy403 FOREIGN KEY (turma_id) REFERENCES tb_turma(id)
);