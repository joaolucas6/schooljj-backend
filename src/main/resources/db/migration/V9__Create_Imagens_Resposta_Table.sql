CREATE TABLE imagens_resposta (
	resposta_id int8 NOT NULL,
	imagem_url varchar(255) NULL,
	CONSTRAINT fk6m91e41k24l57c1pra6hw9s2b FOREIGN KEY (resposta_id) REFERENCES tb_resposta(id)
);