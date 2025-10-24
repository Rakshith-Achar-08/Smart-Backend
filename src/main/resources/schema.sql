
--you must allow MySQL to store too;
--to do this execute query: SET GLOBAL local_infile = 1;

-- Command for the massive shapes file
LOAD DATA LOCAL INFILE 'src/main/resources/Data/shapes.txt'
INTO TABLE shape
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(shape_id, shape_pt_lat, shape_pt_lon, shape_pt_sequence);


-- Command for the massive stop_times file
LOAD DATA LOCAL INFILE 'src/main/resources/Data/stop_times.txt'
INTO TABLE stop_time
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(trip_id, arrival_time, departure_time, stop_id, stop_sequence, stop_headings);