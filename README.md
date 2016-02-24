-----------------------------------------------------------
Criação do Banco - Banco Utilizado MySQL 5.5
-----------------------------------------------------------

delimiter $$

CREATE DATABASE `xyincgps` /*!40100 DEFAULT CHARACTER SET utf8 */$$;

CREATE TABLE `poi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descriptionPOI` varchar(100) NOT NULL,
  `referenceY` int(11) NOT NULL,
  `referenceX` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8$$;


INSERT INTO `poi` (`id`,`descriptionPOI`,`referenceY`,`referenceX`) VALUES (1,'Lanchonete',12,27);
INSERT INTO `poi` (`id`,`descriptionPOI`,`referenceY`,`referenceX`) VALUES (2,'Posto',18,31);
INSERT INTO `poi` (`id`,`descriptionPOI`,`referenceY`,`referenceX`) VALUES (3,'Joalheria',12,15);
INSERT INTO `poi` (`id`,`descriptionPOI`,`referenceY`,`referenceX`) VALUES (4,'Floricultura',21,19);
INSERT INTO `poi` (`id`,`descriptionPOI`,`referenceY`,`referenceX`) VALUES (5,'Pub',8,12);
INSERT INTO `poi` (`id`,`descriptionPOI`,`referenceY`,`referenceX`) VALUES (6,'Supermercado',6,23);
INSERT INTO `poi` (`id`,`descriptionPOI`,`referenceY`,`referenceX`) VALUES (7,'Churrascaria',2,28);

-----------------------------------------------------------
Descrição Projeto
-----------------------------------------------------------
Uso de frameworks:
	- Hibernate
	- Maven
	- JPA
	- JSON
	- JUnit
	
URL: 											http://localhost:8080/xyincgps/rest
(Post) salvar: 									http://localhost:8080/xyincgps/rest/POI/save
(GET)  listar por referencia:					http://localhost:8080/xyincgps/rest/POI/search?referenceX=[referencia x]&referenceY=[referencia Y]
(GET)  listar por referencia e max distancia:	http://localhost:8080/xyincgps/rest/POI/searchMax?referenceX=[referencia x]&referenceY=[referencia Y]&maxDistance=[distancia max]

https://github.com/rogerincampari/xy-inc.git
