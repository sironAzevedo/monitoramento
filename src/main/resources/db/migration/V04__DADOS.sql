-- ADICIONANDO CLINTES
INSERT INTO FRDM.TB_CLIENTE(NOME, CPF, FL_SEXO, DT_NASCIMENTO, CELULAR) VALUES ('JOÃO DA SILVA', '84106263068', 'M', '1980-01-01', '(73) 92149-1301');
INSERT INTO FRDM.TB_CLIENTE(NOME, CPF, FL_SEXO, DT_NASCIMENTO, CELULAR) VALUES ('MARIA DA SILVA', '45686281050', 'F', '1985-01-01', '(54) 97305-7617');

-- ADICIONANDO OPERAÇÕES
INSERT INTO FRDM.TB_OPERACAO(TIPO_OPERACAO) VALUES ('CARTAO');
INSERT INTO FRDM.TB_OPERACAO(TIPO_OPERACAO) VALUES ('TRANSFERENCIA');
INSERT INTO FRDM.TB_OPERACAO(TIPO_OPERACAO) VALUES ('DOC');
INSERT INTO FRDM.TB_OPERACAO(TIPO_OPERACAO) VALUES ('TED');