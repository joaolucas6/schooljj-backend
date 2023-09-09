CREATE TABLE professores_disciplinas (
	disciplina_id int8 NOT NULL,
	professor_id int8 NOT NULL,
	CONSTRAINT fk1u4wfcxiofjq6s7y0kwriscxb FOREIGN KEY (disciplina_id) REFERENCES tb_disciplina(id),
	CONSTRAINT fkr1ryi7ipwaewjg1k3vhi7849r FOREIGN KEY (professor_id) REFERENCES tb_user(id)
);