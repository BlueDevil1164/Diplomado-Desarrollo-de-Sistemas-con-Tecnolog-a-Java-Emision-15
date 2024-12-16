/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `catalogoLaptops`;
CREATE TABLE IF NOT EXISTS `catalogoLaptops` (
	catalogoLaptops_id INTEGER NOT NULL AUTO_INCREMENT,
    cveLaptop VARCHAR(8) NOT NULL,
    descripcion VARCHAR(100) NOT NULL UNIQUE,
  PRIMARY KEY (`catalogoLaptops_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla catalogoLaptops: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `catalogoLaptops` DISABLE KEYS */;
INSERT INTO `catalogoLaptops` (`catalogoLaptops_id`, `cveLaptop`, `descripcion`) VALUES
	(1, 'HP', 'HP'),
	(2, 'LEN', 'Lenovo'),
	(3, 'ACC', 'Acer');
/*!40000 ALTER TABLE `catalogoLaptops` ENABLE KEYS */;

-- Volcando estructura para tabla laptop_type
DROP TABLE IF EXISTS `laptop_type`;
CREATE TABLE IF NOT EXISTS `laptop_type` (
  `laptop_type_id` int NOT NULL AUTO_INCREMENT,
  `cveLaptop` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`laptop_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laptop_type: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `laptop_type` DISABLE KEYS */;
INSERT INTO `laptop_type` (`laptop_type_id`, `cveLaptop`, `descripcion`) VALUES
	(1, 'Familiar', 'DISPONIBLE'),
	(2, 'Escolar', 'DISPONIBLE'),
	(3, 'Laboral', 'DISPONIBLE');
/*!40000 ALTER TABLE `laptop_type` ENABLE KEYS */;

-- Volcando estructura para tabla laptop
DROP TABLE IF EXISTS `laptop`;
CREATE TABLE IF NOT EXISTS `laptop` (
  `laptop_id` int NOT NULL AUTO_INCREMENT,
  `modelo` VARCHAR(50) NOT NULL,
  `pantalla` INT NOT NULL,
  `marca` VARCHAR(8) NOT NULL,
  `color` VARCHAR(100) NOT NULL,
  `ram` INT NOT NULL,
  `laptop_type_id` int NOT NULL,
  PRIMARY KEY (`laptop_id`),
  KEY `fk_laptop_type` (`laptop_type_id`),
  CONSTRAINT `fk_laptop_type` FOREIGN KEY (`laptop_type_id`) REFERENCES `laptop_type` (`laptop_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laptop: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
INSERT INTO `laptop` (`laptop_id`, `modelo`, `pantalla`, `marca`, `color`, `ram`, `laptop_type_id`) VALUES
  (1, '15-fa1006la', 16, 'HP', 'Azul', 8, 3),
  (2, '15-fa1006la', 8, 'HP', 'Verde', 16, 2),
  (3, '15-fa1006la', 32, 'HP', 'Roja', 16, 1);
/*!40000 ALTER TABLE `laptop` ENABLE KEYS */;

-- Volcando estructura para tabla means_laptop
DROP TABLE IF EXISTS `means_laptop`;
CREATE TABLE IF NOT EXISTS `means_laptop` (
  `means_laptop_id` int NOT NULL AUTO_INCREMENT,
  `value` varchar(300) NOT NULL,
  `laptop_id` int NOT NULL,
  `catalogoLaptops_id` int NOT NULL,
  PRIMARY KEY (`means_laptop_id`),
  KEY `fk_means_laptop_laptop` (`laptop_id`),
  KEY `fk_means_laptop_catalogoLaptops` (`catalogoLaptops_id`),
  CONSTRAINT `fk_means_laptop_laptop` FOREIGN KEY (`laptop_id`) REFERENCES `laptop` (`laptop_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_means_laptop_catalogoLaptops` FOREIGN KEY (`catalogoLaptops_id`) REFERENCES `catalogoLaptops` (`catalogoLaptops_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla means_laptop: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `means_laptop` DISABLE KEYS */;
INSERT INTO `means_laptop` (`means_laptop_id`, `value`, `laptop_id`, `catalogoLaptops_id`) VALUES
  (1, 'A', 3, 3),
  (2, 'B', 1, 2),
  (3, 'C', 2, 1);
/*!40000 ALTER TABLE `means_laptop` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
