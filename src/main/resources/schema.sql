
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


delete from bus_details;

INSERT INTO bus_details(route_id, bus_number, start_point, end_point, category, status, capacity, license_plate) VALUES
('335E', '335E', 'Kempegowda Bus Station', 'Kadugodi', 'Ordinary', 'Running', 60, "KA-01 F-8987"),
('500D', '500D', 'Kempegowda Bus Station', 'Banashankari', 'Ordinary', 'Running', 60, "KA-01 F-4534"),
('215-NE ANP11-KMT-VSD', '215-NE', '11th Block Anjanapura', 'Vidhana Soudha', 'Ordinary', 'Running', 60, "KA-01 F-1312"),
('402-B YSTF-VSD-SBS', '402-B', '5th Phase Yelahanka New Town', 'Shivajinagara Bus Station', 'Ordinary', 'Running', 60, "KA-01 F-5644"),
('280-F YSTF-HSK', '280-F', '5th Phase Yelahanka New Town', 'Hosakote Bus Stand', 'Ordinary', 'Running', 60, "KA-01 F-5433"),
('507-D', '507-D', '5th Phase Yelahanka New Town', 'KR Pura Govt Hospital', 'Ordinary', 'Running', 60, "KA-01 F-2342"),
('285-MC YSTF-NES-DBP', '285-MC', '5th Phase Yelahanka New Town', 'Doddaballapura Bus Stand', 'Ordinary', 'Running', 60, "KA-01 F-6754"),
('G-9 SBS-YSTF', 'G-9', '5th Phase Yelahanka New Town', 'Shivajinagara Bus Station', 'Vayu Vajra', 'Running', 60, "KA-01 F-4544"),
('302 KLN-SBS', '302', '80 feet Road Kalyananagara', 'Shivajinagara Bus Station', 'Ordinary', 'Running', 60, "KA-01 F-9090"),
('BC-7C', 'BC-7C', '8th Mile Dasarahalli', '8th Mile Dasarahalli', 'Big Circle', 'Running', 60, "KA-01 F-8980"),
('250-DD', '250-DD', '8th Mile Dasarahalli', '8th Mile Dasarahalli Arrival', 'Ordinary', 'Running', 60, "KA-01 F-6767"),
('MF-25', 'MF-25', '8th Mile Dasarahalli', 'Thippennahalli', 'Ordinary', 'Running', 60, "KA-01 F-7777"),
('60-A CLO-JNN', '60-A', '9th Block Jayanagara', 'Chandra Layout', 'Ordinary', 'Running', 60, "KA-01 F-1111"),
('237-J', '237-J', '9th Block Jayanagara', 'Panchasheela Nagara', 'Ordinary', 'Running', 60, "KA-01 F-2406"),
('347-K', '347-K', 'AECS Layout Singasandra', 'KR Market', 'Ordinary', 'Running', 60, "KA-01 F-5445"),
('347-N', '347-N', 'AECS Layout Singasandra', 'Kempegowda Bus Station', 'Ordinary', 'Running', 60, "KA-01 F-5877"),
('45-G AGSLC-KBS', '45-G', 'AGS Layout Cross', 'Kempegowda Bus Station', 'Ordinary', 'Running', 60, "KA-01 F-8787"),
('401-AK ABG-PSS', '401-AK', 'Abbigere', 'Peenya 2nd stage', 'Ordinary', 'Running', 60, "KA-01 F-1986"),
('V-250SB', 'V-250SB', 'Acharya Institute of Technology', 'KR Market', 'Volvo', 'Running', 60, "KA-01 F-2387"),
('258-N ASDW-VSD-KBS', '258-N', 'Adarshanagara Water Tank', 'Kempegowda Bus Station', 'Ordinary', 'Running', 60, "KA-01 F-4540"),
('Vivek_Test14', 'Vivek_Test14', '10th Cross Lingadhiranahalli', '10th Cross Magadi Road', 'Test Route', 'Running', 60, "KA-01 F-9898"),
('VLO1-KGR', 'VLO1-KGR', '1st Block Vishweshwaraiah Layout', 'Kengeri Bus Station', 'Ordinary', 'Running', 60, "KA-01 F-9999"),
('2KVP-JHE', '2KVP-JHE', '2nd stage Kuvempunagara', 'Jalahalli East', 'Ordinary', 'Running', 60, "KA-01 F-1112"),
('300-E ADMC-KRPGH', '300-E', 'ADMC Quarters Office', 'KR Pura Govt Hospital', 'Ordinary', 'Running', 60, "KA-01 F-2223"),
('4DYNG-YHK', '401', 'Adishwara Bombay Dying', 'Yelahanka Old Town', 'Ordinary', 'Running', 60, "KA-01 F-3786");