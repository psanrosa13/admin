CREATE TABLE public.funcionario (
    id UUID NOT NULL PRIMARY KEY,
    nome VARCHAR(100),
    documento VARCHAR(15),
    tipo_documento VARCHAR(10)
);