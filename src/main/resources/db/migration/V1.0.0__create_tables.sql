SET TIME ZONE 'UTC';

CREATE TABLE IF NOT EXISTS municipio ( 
	id bigserial not null,
    nome varchar(60) not null,
    unidade_federacao varchar(2) not null,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS produto (
    codigo bigserial not null,
    nome varchar(100) not null,
    descricao varchar(500),
    preco float,
    primary key (codigo)
);

CREATE TABLE IF NOT EXISTS cliente (
    cpf bigint AUTO_INCREMENT,
    nome varchar(50) not null,
    localidade bigint,
    primary key (cpf),
    CONSTRAINT pk_cliente PRIMARY KEY (cpf),
    FOREIGN KEY (localidade) REFERENCES municipio(id)
);

CREATE TABLE IF NOT EXISTS venda (
    id bigserial not null,
    data_venda timestamp not null,
    cliente bigint,
    primary key (id),
    CONSTRAINT pk_venda PRIMARY KEY (id),
    FOREIGN KEY (cliente) REFERENCES cliente(cpf)
);

CREATE TABLE IF NOT EXISTS item (
    id bigserial not null,
    quantidade int not null,
    valor_unitario double not null,
    produto bigint,
    venda bigint,
    primary key (id),
    CONSTRAINT pk_item PRIMARY KEY (id),
    FOREIGN KEY (produto) REFERENCES produto(codigo),
    FOREIGN KEY (venda) REFERENCES venda(id)
);

INSERT INTO municipio(nome, unidade_federacao)
VALUES 
('Belo Horizonte', 'BH'),
('Boa Vista', 'RR'),
('Paraná', 'PR'),
('Fortaleza', 'CE'),
('Manaus', 'AM'),
('Brasília', 'DF'),
('Rio de Janeiro', 'RJ'),
('Porto Alegre', 'RS'),
('São Paulo', 'SP');

INSERT INTO produto(nome, descricao, preco)
VALUES 
('Camera Inteligente Wi-Fi', 'Câmera Inteligente Wi-Fi, Sensor de Movimento e visão noturna, Compatível com Alexa Echo Show, Steck, Branca', 249.22),
('Lâmpada Smart Inteligente Intelbras', 'Lâmpada Smart Inteligente EWS 410 com 16 milhões de cores Wi-Fi compatível com Alexa Intelbras', 69.00),
('Mouse Gamer Sem Fio Logitech G502', 'Mouse Gamer Sem Fio Logitech G502 LIGHTSPEED com Tecnologia RGB LIGHTSYNC, Ajustes de Peso, 11 Botóes Programáveis, Sensor HERO 25K e Bateria Recarregável - Compatível com POWERPLAY', 656.00),
('Cadeira Gamer Snake Naja Vermelha', null, 851.59),
('Combo Teclado e Mouse sem fio Logitech MK470', 'Combo Teclado e Mouse sem fio Logitech MK470 com Design Slim, Digitação e Clique Silencioso, Mouse Ambidestro, Conexão USB e Pilhas Inclusas', 279.00),
('JBL Fone de Ouvido Bluetooth', 'JBL, Fone de Ouvido Bluetooth, Tune 215 BT - Branco', 181.54),
('Interruptor Smart Wi-Fi Touch 2', 'intelbras Interruptor Smart Wi-Fi Touch 2 EWS 1002 Branco', 143.94),
('Controlador de irrigação de água inteligente', 'Duotar Controlador de irrigação de água inteligente Tipo botão Temporizador de irrigação de jardim Temporizador de irrigação auático operado por bateria para jardins Countyards Lawns Greenhouse', 107.87),
('Suporte Notebook Laptop Vertical Apoio De Mesa Fino P20x', null, 39.90),
('Webcam Logitech com Microfone Embutido', 'Webcam HD Logitech C505 com Microfone Embutido de Longo Alcance e 3 MP para Chamadas e Gravações em Vídeo Widescreen', 205.99);

INSERT INTO cliente(cpf, nome, localidade)
VALUES 
(92974139272, 'Leonardo Holanda Arruda', 2),
(83456457200, 'George Melo Santos', 2),
(86976433090, 'Joana Sampaio da Silva', 2),
(54048454064, 'Maria Antonia Prado', 7),
(51085287017, 'Marcos Almeida', 7),
(75757360003, 'Juliana Fernandes', 9),
(18898491034, 'Bruna Melo', 9);

INSERT INTO venda(data_venda, cliente)
VALUES
(now(), 92974139272),
(now(), 92974139272),
(now(), 92974139272),
(now(), 92974139272),
(now(), 83456457200),
(now(), 83456457200),
(now(), 86976433090),
(now(), 54048454064),
(now(), 92974139272);

INSERT INTO item(produto, quantidade, valor_unitario, venda)
VALUES 
(4, 1, 851.59, 1),
(9, 1, 39.90, 2),
(7, 3, 143.94, 2),
(10, 1, 205.99, 3),
(2, 5, 69.00, 4),
(3, 2, 656.00, 5),
(8, 2, 107.87, 6),
(3, 5, 656.00, 7),
(3, 10, 656.00, 8),
(3, 1, 656.00, 9);