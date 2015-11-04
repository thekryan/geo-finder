-- rodzaje lokalizacji
INSERT INTO `object_types` (`id`, `type_name`) VALUES ('1', 'Hotel');
INSERT INTO `object_types` (`id`, `type_name`) VALUES ('2', 'Bank');
INSERT INTO `object_types` (`id`, `type_name`) VALUES ('3', 'Restauraca');

--obiekty lokalizacji

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Qubus", "Dworcowa 27, 44-100 Gliwice", 1, GeomFromText( 'POINT(18.669117 50.293191)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Royal", "Jana Matejki 10, Gliwice", 1, GeomFromText( 'POINT(18.667894 50.293329)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Trzy Œwiaty", "Jana Kilñiskiego 14a, Gliwice", 1, GeomFromText( 'POINT(18.670618 50.276505)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Novotel", "Aleja Walentego RoŸdzieñskiego 16, 40-202 Katowice", 1, 
			GeomFromText( 'POINT(19.033341 50.261168)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Radisson Blu Sobieski Hotel", "Plac Artura Zawiszy 1, 02-025 Warszawa", 1, 
			GeomFromText( 'POINT(20.988863 52.224053)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Hotel Lidia SPA & Wellness", "Dorszowa 3, 76-150 Dar³owo", 1, 
			GeomFromText( 'POINT(16.376794 54.437591)' ));


INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Hotel Espanya", "Carrer Sant Pau, 08001 Barcelona, Hiszpania", 1, 
			GeomFromText( 'POINT(2.17289 41.381574)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Jumeirah Beach Hotel", "Jumeirah Rd. - Dubai - Zjednoczone Emiraty Arabskie", 1, 
			GeomFromText( 'POINT(55.191193 25.145906)' ));


INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("New York's Hotel Pennsylvania", "401 7th Avenue, New York, NY, Stany Zjednoczone", 1, 
			GeomFromText( 'POINT(-73.99086 40.750248)' ));


INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("PKO Bank Polski. Oddzia³ 4", "Jana III Sobieskiego 6, 41-300 D¹browa Górnicza", 3, 
			GeomFromText( 'POINT(19.182987 50.327491)' ));


INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Alior Bank - Oddzia³ (oficjalny)", "Aleja Tadeusza Koœciuszki 21 41-300 D¹browa Górnicza", 3, 
			GeomFromText( 'POINT(19.186721 50.324478 )' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("PKO BP II Oddzia³", "Zuzanny 20 Sosnowiec", 3, 
			GeomFromText( 'POINT(19.16153 50.303705 )' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Getin Bank", "Ignacego Moœcickiego 21 Sosnowiec", 3, 
			GeomFromText( 'POINT(19.13578 50.282484 )' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("PKO Bank Polski", "Aleja Walentego RoŸdzieñskiego 88A Katowice", 3, 
			GeomFromText( 'POINT(19.037247 50.261062 )' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("ING Bank Slaski", "Franciszka Zubrzyckiego 18 Gliwice", 3, 
			GeomFromText( 'POINT(18.666759 50.283444)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Indian Dreams. Restauracja indyjska", "Dolnych Wa³ów 5 44-100 Gliwice", 2, 
			GeomFromText( 'POINT(18.668346 50.294562)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Sphinx", "Plac Wolnoœci Zabrze", 2, 
			GeomFromText( 'POINT(18.784518 50.307597)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Zajazd Bachus - Hotel Restauracja", "Stanis³awa Staszica 42 41-303 D¹browa Górnicza", 2, 
			GeomFromText( 'POINT(19.220409 50.317682)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Restauracja Leœna", "Brunona Jasieñskiego 88 41-215 Sosnowiec", 2, 
			GeomFromText( 'POINT(19.243755 50.301292)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Caprese Pizzeria i Restauracja", "Kasztanowa 3 41-200 Sosnowiec", 2, 
			GeomFromText( 'POINT(19.128914 50.294987)' ));

INSERT INTO geo_objects (name, address, object_types_id, coords) 
	VALUES("Sicilia", "Jana Kochanowskiego 2 Katowice", 2, 
			GeomFromText( 'POINT(19.020252 50.25873)' ));







