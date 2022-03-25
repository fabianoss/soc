CREATE TABLE exame (rowid bigint auto_increment,nm_exame VARCHAR(255));
ALTER TABLE exame ADD PRIMARY KEY (rowid);
ALTER TABLE exame ADD CONSTRAINT exameUk UNIQUE (nm_exame);
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue');

CREATE TABLE usuario (rowid bigint auto_increment,username VARCHAR(4000),password VARCHAR(4000));
ALTER TABLE usuario ADD PRIMARY KEY (rowid);
ALTER TABLE usuario ADD CONSTRAINT usuarioeUk UNIQUE (username);
INSERT INTO usuario (username,password) VALUES ('soc','soc');

CREATE TABLE funcionario (rowid bigint auto_increment,nome VARCHAR(4000));
ALTER TABLE funcionario ADD PRIMARY KEY (rowid);
ALTER TABLE funcionario ADD CONSTRAINT funcionarioUk UNIQUE (nome);
INSERT INTO funcionario (nome) VALUES ('fabiano');

CREATE TABLE exame_funcionario (rowid bigint auto_increment, rowid_exame bigint not null, rowid_funcionario bigint not null, data_exame Date not null);
ALTER TABLE exame_funcionario ADD PRIMARY KEY (rowid);
ALTER TABLE exame_funcionario ADD FOREIGN KEY (rowid_exame) REFERENCES exame (rowid);
ALTER TABLE exame_funcionario ADD FOREIGN KEY (rowid_funcionario) REFERENCES funcionario (rowid);
INSERT INTO exame_funcionario (rowid_exame,rowid_funcionario,data_exame) VALUES (1,1,CURRENT_DATE());
