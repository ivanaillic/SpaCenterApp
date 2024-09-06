/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.28-MariaDB : Database - spa_seminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spa_seminarski` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `spa_seminarski`;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `sifraKlijenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `starost` int(11) NOT NULL,
  `brojTelefona` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sifraTipaKlijenta` bigint(20) NOT NULL,
  PRIMARY KEY (`sifraKlijenta`),
  KEY `sifraTipaKlijenta` (`sifraTipaKlijenta`),
  CONSTRAINT `klijent_ibfk_1` FOREIGN KEY (`sifraTipaKlijenta`) REFERENCES `tipklijenta` (`sifraTipaKlijenta`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `klijent` */

insert  into `klijent`(`sifraKlijenta`,`ime`,`prezime`,`starost`,`brojTelefona`,`email`,`sifraTipaKlijenta`) values 
(13,'Petar','Petrovic',28,'0654367896','petar@gmail.com',1),
(15,'Milica','Milic',31,'0643625142','milica@gmail.com',2),
(16,'Anja','Milenkovic',28,'0627362822','anja@gmail.com',1),
(17,'Sofija','Milic',20,'0614263542','sofija@gmail.com',2),
(19,'Danica','Maric',25,'0657897534','danica@gmail.com',1);

/*Table structure for table `napomenazauslugu` */

DROP TABLE IF EXISTS `napomenazauslugu`;

CREATE TABLE `napomenazauslugu` (
  `sifraUsluge` bigint(20) NOT NULL,
  `redniBroj` bigint(20) NOT NULL AUTO_INCREMENT,
  `opisNapomene` varchar(50) DEFAULT NULL,
  `sifraTipaNapomene` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sifraUsluge`,`redniBroj`),
  KEY `redniBroj` (`redniBroj`),
  KEY `sifraTipaNapomene` (`sifraTipaNapomene`),
  CONSTRAINT `napomenazauslugu_ibfk_1` FOREIGN KEY (`sifraUsluge`) REFERENCES `usluga` (`sifraUsluge`) ON DELETE CASCADE,
  CONSTRAINT `napomenazauslugu_ibfk_2` FOREIGN KEY (`sifraTipaNapomene`) REFERENCES `tipnapomenezauslugu` (`sifraTipaNapomene`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `napomenazauslugu` */

insert  into `napomenazauslugu`(`sifraUsluge`,`redniBroj`,`opisNapomene`,`sifraTipaNapomene`) values 
(20,24,'Paziti na temperaturu, ne prelaziti 90 stepeni',1),
(23,34,'Izbegavati izlaganje suncu bar 24h.',3),
(25,27,'Klijent želi dodatni piling pre masaže',2),
(27,29,'Izbegavati sunčanje nakon depilacije',3),
(28,30,'Klijent ima osetljivu kožu',3),
(31,33,'Nije za osobe sa osetljivom kozom',1);

/*Table structure for table `termin` */

DROP TABLE IF EXISTS `termin`;

CREATE TABLE `termin` (
  `sifraKlijenta` bigint(20) NOT NULL,
  `sifraUsluge` bigint(20) NOT NULL,
  `datumVremeTermina` datetime NOT NULL,
  `brojProstorije` int(11) NOT NULL,
  `napomena` varchar(50) DEFAULT NULL,
  `vaucer` varchar(50) NOT NULL,
  `konacnaCena` double NOT NULL,
  PRIMARY KEY (`sifraKlijenta`,`sifraUsluge`,`datumVremeTermina`),
  KEY `sifraUsluge` (`sifraUsluge`),
  CONSTRAINT `termin_ibfk_1` FOREIGN KEY (`sifraKlijenta`) REFERENCES `klijent` (`sifraKlijenta`) ON DELETE CASCADE,
  CONSTRAINT `termin_ibfk_2` FOREIGN KEY (`sifraUsluge`) REFERENCES `usluga` (`sifraUsluge`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `termin` */

insert  into `termin`(`sifraKlijenta`,`sifraUsluge`,`datumVremeTermina`,`brojProstorije`,`napomena`,`vaucer`,`konacnaCena`) values 
(13,25,'2024-07-31 11:00:00',5,'','POPUST10',2250),
(13,25,'2024-08-01 11:00:00',5,'','POPUST10',2250),
(15,19,'2024-07-27 12:00:00',3,'Manikir sa šaranjem pa noktima','POPUST20',960),
(15,23,'2024-07-27 11:00:00',3,'Koristiti hladan vosak','POPUST20',800),
(16,21,'2024-07-31 11:00:00',6,'','BEZ_POPUSTA',1800),
(17,25,'2024-07-27 11:00:20',4,'','POPUST20',2000);

/*Table structure for table `tipklijenta` */

DROP TABLE IF EXISTS `tipklijenta`;

CREATE TABLE `tipklijenta` (
  `sifraTipaKlijenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `nazivTipaKlijenta` varchar(50) NOT NULL,
  PRIMARY KEY (`sifraTipaKlijenta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tipklijenta` */

insert  into `tipklijenta`(`sifraTipaKlijenta`,`nazivTipaKlijenta`) values 
(1,'Gold'),
(2,'Silver'),
(3,'Bronze');

/*Table structure for table `tipnapomenezauslugu` */

DROP TABLE IF EXISTS `tipnapomenezauslugu`;

CREATE TABLE `tipnapomenezauslugu` (
  `sifraTipaNapomene` bigint(20) NOT NULL AUTO_INCREMENT,
  `nazivTipaNapomene` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sifraTipaNapomene`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tipnapomenezauslugu` */

insert  into `tipnapomenezauslugu`(`sifraTipaNapomene`,`nazivTipaNapomene`) values 
(1,'Napomena za specifičnu uslugu'),
(2,'Dodatni zahtev klijenta'),
(3,'Preporuka terapeuta');

/*Table structure for table `usluga` */

DROP TABLE IF EXISTS `usluga`;

CREATE TABLE `usluga` (
  `sifraUsluge` bigint(20) NOT NULL AUTO_INCREMENT,
  `nazivUsluge` varchar(50) NOT NULL,
  `cenaUsluge` double NOT NULL,
  `trajanjeUsluge` int(11) NOT NULL,
  `sifraVrsteUsluge` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sifraUsluge`),
  KEY `sifraVrsteUsluge` (`sifraVrsteUsluge`),
  CONSTRAINT `usluga_ibfk_1` FOREIGN KEY (`sifraVrsteUsluge`) REFERENCES `vrstausluge` (`sifraVrsteUsluge`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `usluga` */

insert  into `usluga`(`sifraUsluge`,`nazivUsluge`,`cenaUsluge`,`trajanjeUsluge`,`sifraVrsteUsluge`) values 
(19,'Klasičan manikir',1300,45,1),
(20,'Gel lak manikir',1500,60,1),
(21,'Parna sauna',1900,30,2),
(22,'Infracrvena sauna',2000,40,2),
(23,'Depilacija nogu',1200,35,3),
(24,'Depilacija ruku',800,20,3),
(25,'Relaks masaža',2500,60,4),
(26,'Sportska masaža',3200,80,4),
(27,'Aromaterapija masaža',2700,60,4),
(28,'Thai masaža',3200,90,4),
(31,'Masaza vulkanskim kamenjem',8000,40,4);

/*Table structure for table `vrstausluge` */

DROP TABLE IF EXISTS `vrstausluge`;

CREATE TABLE `vrstausluge` (
  `sifraVrsteUsluge` bigint(20) NOT NULL AUTO_INCREMENT,
  `nazivVrsteUsluge` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sifraVrsteUsluge`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `vrstausluge` */

insert  into `vrstausluge`(`sifraVrsteUsluge`,`nazivVrsteUsluge`) values 
(1,'Manikir'),
(2,'Sauna'),
(3,'Depilacija'),
(4,'Masaza'),
(5,'Tretman lica');

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `sifraZaposlenog` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `korisnickoIme` varchar(50) NOT NULL,
  `lozinka` varchar(50) NOT NULL,
  PRIMARY KEY (`sifraZaposlenog`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`sifraZaposlenog`,`ime`,`prezime`,`korisnickoIme`,`lozinka`) values 
(1,'Ivana','Ilic','ivana123','ivana123'),
(2,'Jovana','Jovic','jovana123','jovana123'),
(3,'Marko','Markovic','marko123','marko123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
