CREATE TABLE IF NOT EXISTS `person` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `primeiro_nome` varchar(80) NOT NULL,
    `segundo_nome` varchar(80) NOT NULL,
    `address` varchar(100) NOT NULL,
    `gender` varchar(10) NOT NULL,
   PRIMARY KEY (`id`)
    );

