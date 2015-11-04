CREATE DATABASE `geo_finder`;


CREATE TABLE `geo_objects` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `object_types_id` int(11) DEFAULT NULL,
  `coords` point NOT NULL,
  PRIMARY KEY (`id`),
  SPATIAL KEY `GEO_POINT_INDEX` (`coords`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `object_types` (
  `id` int(10) unsigned NOT NULL,
  `type_name` varchar(45) NOT NULL,
  `enum_id` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

