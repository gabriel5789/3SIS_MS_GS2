
DROP TABLE indicadores_det;
DROP TABLE indicadores_mstr;
DROP TABLE objetivos;

CREATE TABLE indicadores_det (
    id_indicador VARCHAR2(10 CHAR) NOT NULL,
    ano          NUMBER(4) NOT NULL,
    regiao       VARCHAR2(60 CHAR) NOT NULL,
    valor        NUMBER(6, 2) NOT NULL
);

ALTER TABLE indicadores_det
    ADD CONSTRAINT indicadores_det_pk PRIMARY KEY ( ano,
                                                    regiao,
                                                    id_indicador );

CREATE TABLE indicadores_mstr (
    id_indicador   VARCHAR2(10 CHAR) NOT NULL,
    desc_indicador VARCHAR2(255 CHAR) NOT NULL,
    tipo_indicador VARCHAR2(20 CHAR) NOT NULL,
    id_objetivo    VARCHAR2(10 CHAR) NOT NULL
);

ALTER TABLE indicadores_mstr ADD CONSTRAINT indicadores_mstr_pk PRIMARY KEY ( id_indicador );

CREATE TABLE objetivos (
    id_objetivo          VARCHAR2(10 CHAR) NOT NULL,
    desc_objetivo_global VARCHAR2(512 CHAR) NOT NULL,
    desc_objetivo_brasil VARCHAR2(512 CHAR) NOT NULL
);

ALTER TABLE objetivos ADD CONSTRAINT objetivos_pk PRIMARY KEY ( id_objetivo );

ALTER TABLE indicadores_det
    ADD CONSTRAINT indicadores_det_mstr_fk FOREIGN KEY ( id_indicador )
        REFERENCES indicadores_mstr ( id_indicador );

ALTER TABLE indicadores_mstr
    ADD CONSTRAINT indicadores_objetivos_fk FOREIGN KEY ( id_objetivo )
        REFERENCES objetivos ( id_objetivo );
