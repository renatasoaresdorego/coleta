CREATE SEQUENCE seq_agenda START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_caminhao START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_coleta START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_morador START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_rota START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_usuario START WITH 1 INCREMENT BY 1;

CREATE TABLE ponto_de_coleta
(
    id_ponto_coleta NUMBER(38, 0) NOT NULL,
    ds_endereco     VARCHAR2(255),
    dt_prox_coleta  DOUBLE PRECISION,
    dt_ult_coleta   DOUBLE PRECISION,
    residuo         VARCHAR2(255),
    CONSTRAINT pk_pontodecoleta PRIMARY KEY (id_ponto_coleta)
);

CREATE TABLE ponto_de_coleta_agendamentos_de_coleta
(
    ponto_de_coleta_id_ponto_coleta  NUMBER(38, 0) NOT NULL,
    agendamentos_de_coleta_id_agenda NUMBER(38, 0) NOT NULL
);

CREATE TABLE t_rec_agenda
(
    id_agenda                       NUMBER(38, 0) NOT NULL,
    dt_prox_coleta                  date,
    dt_ult_coleta                   date,
    id_rota                         NUMBER(38, 0),
    ponto_de_coleta_id_ponto_coleta NUMBER(38, 0),
    CONSTRAINT pk_t_rec_agenda PRIMARY KEY (id_agenda)
);

CREATE TABLE t_rec_caminhao
(
    id_caminhao        NUMBER(38, 0) NOT NULL,
    nr_capacidade      NUMBER(38, 0),
    tx_local_temp_real VARCHAR2(255),
    tx_placa           VARCHAR2(255),
    st_servico         NUMBER(1),
    id_rota            NUMBER(38, 0),
    CONSTRAINT pk_t_rec_caminhao PRIMARY KEY (id_caminhao)
);

CREATE TABLE t_rec_morador
(
    id_morador   NUMBER(38, 0) NOT NULL,
    nm_morador   VARCHAR2(255),
    st_rec_notif NUMBER(1),
    tx_telefone  VARCHAR2(255),
    tx_email     VARCHAR2(255),
    CONSTRAINT pk_t_rec_morador PRIMARY KEY (id_morador)
);

CREATE TABLE t_rec_rota
(
    id_rota   NUMBER(38, 0) NOT NULL,
    nm_rota   VARCHAR2(255),
    ds_inicio VARCHAR2(255),
    ds_final  VARCHAR2(255),
    CONSTRAINT pk_t_rec_rota PRIMARY KEY (id_rota)
);

CREATE TABLE t_rec_rota_agendas
(
    rota_id_rota      NUMBER(38, 0) NOT NULL,
    agendas_id_agenda NUMBER(38, 0) NOT NULL
);

CREATE TABLE t_rec_rota_caminhoes
(
    rota_id_rota          NUMBER(38, 0) NOT NULL,
    caminhoes_id_caminhao NUMBER(38, 0) NOT NULL
);

CREATE TABLE t_rec_usuario
(
    id_usuario         NUMBER(38, 0) NOT NULL,
    tx_cpf             VARCHAR2(255),
    tx_senha           VARCHAR2(255),
    morador_id_morador NUMBER(38, 0),
    ds_role            VARCHAR2(255),
    CONSTRAINT pk_t_rec_usuario PRIMARY KEY (id_usuario)
);

ALTER TABLE ponto_de_coleta_agendamentos_de_coleta
    ADD CONSTRAINT uc_pontodecoletaagendamentosdecole_agendamentosdecoletaidagenda UNIQUE (agendamentos_de_coleta_id_agenda);

ALTER TABLE t_rec_rota_agendas
    ADD CONSTRAINT uc_t_rec_rota_agendas_agendas_id_agenda UNIQUE (agendas_id_agenda);

ALTER TABLE t_rec_rota_caminhoes
    ADD CONSTRAINT uc_t_rec_rota_caminhoes_caminhoes_id_caminhao UNIQUE (caminhoes_id_caminhao);

CREATE UNIQUE INDEX usuario_idx ON t_rec_usuario (tx_cpf);

ALTER TABLE t_rec_agenda
    ADD CONSTRAINT FK_T_REC_AGENDA_ON_ID_ROTA FOREIGN KEY (id_rota) REFERENCES t_rec_rota (id_rota);

ALTER TABLE t_rec_agenda
    ADD CONSTRAINT FK_T_REC_AGENDA_ON_PONTODECOLETA_ID_PONTO_COLETA FOREIGN KEY (ponto_de_coleta_id_ponto_coleta) REFERENCES ponto_de_coleta (id_ponto_coleta);

ALTER TABLE t_rec_caminhao
    ADD CONSTRAINT FK_T_REC_CAMINHAO_ON_ID_ROTA FOREIGN KEY (id_rota) REFERENCES t_rec_rota (id_rota);

ALTER TABLE t_rec_usuario
    ADD CONSTRAINT FK_T_REC_USUARIO_ON_MORADOR_ID_MORADOR FOREIGN KEY (morador_id_morador) REFERENCES t_rec_morador (id_morador);

ALTER TABLE ponto_de_coleta_agendamentos_de_coleta
    ADD CONSTRAINT fk_pondecolagedecol_on_agenda FOREIGN KEY (agendamentos_de_coleta_id_agenda) REFERENCES t_rec_agenda (id_agenda);

ALTER TABLE ponto_de_coleta_agendamentos_de_coleta
    ADD CONSTRAINT fk_pondecolagedecol_on_ponto_de_coleta FOREIGN KEY (ponto_de_coleta_id_ponto_coleta) REFERENCES ponto_de_coleta (id_ponto_coleta);

ALTER TABLE t_rec_rota_agendas
    ADD CONSTRAINT fk_trecrotage_on_agenda FOREIGN KEY (agendas_id_agenda) REFERENCES t_rec_agenda (id_agenda);

ALTER TABLE t_rec_rota_agendas
    ADD CONSTRAINT fk_trecrotage_on_rota FOREIGN KEY (rota_id_rota) REFERENCES t_rec_rota (id_rota);

ALTER TABLE t_rec_rota_caminhoes
    ADD CONSTRAINT fk_trecrotcam_on_caminhao FOREIGN KEY (caminhoes_id_caminhao) REFERENCES t_rec_caminhao (id_caminhao);

ALTER TABLE t_rec_rota_caminhoes
    ADD CONSTRAINT fk_trecrotcam_on_rota FOREIGN KEY (rota_id_rota) REFERENCES t_rec_rota (id_rota);