delimiter $$

CREATE DEFINER=`kryan`@`%` FUNCTION `great_circle_distance`(lat1 double, lon1 double, lat2 double, lon2 double) RETURNS double
    DETERMINISTIC
Begin
		#Promien Ziemi w km
        Declare R double;
		#Odleglosc miedzy punktami w km
		Declare D double; 

		Set R = 6371.009;

		Set D =  R * acos(sin(radians(lat1)) * sin(radians(lat2)) + 
						  cos(radians(lat1)) * cos(radians(lat2)) * cos(radians(lon2 - lon1))); 
        
               		
        Return D;
End$$


delimiter $$

CREATE DEFINER=`kryan`@`%` FUNCTION `haversine_formula_distance`(lat1 double, lon1 double, lat2 double, lon2 double) RETURNS double
BEGIN
	
	#Promien Ziemi w km
	declare R double;
	#Odleglosc miedzy punktami w km
	declare D double;

	#pierwsza szerokosc geograficzna w radianach
	declare lat1_rad double;	
	#druga szerokosc geograficzna w radianach
	declare lat2_rad double;
	
	#roznica szerokosci geograficznych w radianach
	declare dlat_rad double;
	#roznica dlugosci geograficznych w radianach
	declare dlon_rad double;

	declare haversin_dlat double;
	declare haversin_dlon double;

	set R = 6371.009;

	set lat1_rad = radians(lat1);
	set lat2_rad = radians(lat2);
	
	set dlat_rad = radians(lat2 - lat1);
	set dlon_rad = radians(lon2 - lon1);

	set haversin_dlat = sin(dlat_rad/2)*sin(dlat_rad/2);
	set haversin_dlon = sin(dlon_rad/2)*sin(dlon_rad/2);
	
	set D = 2 * R * asin(sqrt(haversin_dlat + cos(lat1_rad)*cos(lat2_rad)*haversin_dlon));	

	return D;
END$$


delimiter $$

CREATE DEFINER=`kryan`@`%` PROCEDURE `fill_geo_objects`(IN size INT(10) )
BEGIN

	DECLARE i DOUBLE(10,1) DEFAULT size; 

	DECLARE lon FLOAT(7,4); 
	DECLARE lat FLOAT(6,4); 
	DECLARE position VARCHAR(100); 

	DELETE FROM geo_objects; 

	WHILE i > 0 DO 
	SET lon = RAND() * 360 - 180; 
	SET lat = RAND() * 180 - 90; 

	SET position = CONCAT( 'POINT(', lon, ' ', lat, ')' ); 

	INSERT INTO geo_objects(name, address, object_types_id, coords)
		VALUES ( CONCAT('name_', i), "test", 1, GeomFromText(position) );
	
	SET i = i - 1; 
	END WHILE; 	

END$$


