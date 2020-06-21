CREATE TABLE IF NOT EXISTS FRDM.TB_CLIENTE
(
    ID BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('FRDM.CLIENTE_ID_SEQ'),
    NOME VARCHAR(255) NOT NULL,
    CPF VARCHAR(255) NOT NULL,
    FL_SEXO FRDM.SEXO NOT NULL,
    DT_NASCIMENTO DATE,
    CELULAR VARCHAR(255) NOT NULL,
    UNIQUE(CPF),
    UNIQUE(CELULAR)
);

CREATE TABLE IF NOT EXISTS FRDM.TB_OPERACAO
(
    ID BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('FRDM.OPERACAO_ID_SEQ'),
    TIPO_OPERACAO VARCHAR (255) NOT NULL
);

CREATE TABLE IF NOT EXISTS FRDM.TB_TRANSACAO
(
    ID BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('FRDM.TRANSACAO_ID_SEQ'),
    COD_CONFIRMACAO BIGINT NOT NULL,
    VALIDADE TIMESTAMP NOT NULL, 
    ID_CLIENTE BIGINT NOT NULL,   
    UNIQUE(COD_CONFIRMACAO),
   
    FOREIGN KEY (ID_CLIENTE) REFERENCES FRDM.TB_CLIENTE(ID)
);