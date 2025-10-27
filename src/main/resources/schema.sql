
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

INSERT INTO bus_details(route_id, bus_number, start_point, end_point, category, status, capacity, license_plate, shape_id) VALUES
--('335E', '335E', 'Kempegowda Bus Station', 'Kadugodi', 'Ordinary', 'Running', 60, 'KA-01 F-8987', 'V-335E DOWN'),
--('335-E', '335E', 'Kadugodi', 'Kempegowda Bus Station', 'Ordinary', 'Running', 60, 'KA-01 F-8987', 'V-335E UP'),

('500-D', '500D', 'Kempegowda Bus Station', 'Banashankari', 'Ordinary', 'Running', 60, 'KA-01 F-4534','V-500D DOWN'),
('500D', '500D', 'Banashankari', 'Kempegowda Bus Station', 'Ordinary', 'Running', 60, 'KA-01 F-4534','V-500D UP'),

('215NE ANP11-KMT-VSD', '215-NE', '11th Block Anjanapura', 'Vidhana Soudha', 'Ordinary', 'Running', 60, 'KA-01 F-1312', '215-NE ANP11-KMT-VSD UP'),
('215-NE ANP11-KMT-VSD', '215-NE', 'Vidhana Soudha', '11th Block Anjanapura', 'Ordinary', 'Running', 60, 'KA-01 F-1312', '215-NE ANP11-KMT-VSD DOWN'),

('402B YSTF-VSD-SBS', '402-B', '5th Phase Yelahanka New Town', 'Shivajinagara Bus Station', 'Ordinary', 'Running', 60, 'KA-01 F-5644', '402-B YSTF-VSD-SBS DOWN'),
('402-B YSTF-VSD-SBS', '402-B', 'Shivajinagara Bus Station', '5th Phase Yelahanka New Town', 'Ordinary', 'Running', 60, 'KA-01 F-5644', '402-B YSTF-VSD-SBS UP' ),

('280F YSTF-HSK', '280-F', '5th Phase Yelahanka New Town', 'Hosakote Bus Stand', 'Ordinary', 'Running', 60, 'KA-01 F-5433', '280-F YSTF-HSK UP'),
('280-F YSTF-HSK', '280-F', 'Hosakote Bus Stand', '5th Phase Yelahanka New Town', 'Ordinary', 'Running', 60, 'KA-01 F-5433', '280-F YSTF-HSK UP'),

('507D', '507-D', '5th Phase Yelahanka New Town', 'KR Pura Govt Hospital', 'Ordinary', 'Running', 60, 'KA-01 F-2342', '507-D UP'),
('507-D', '507-D', 'KR Pura Govt Hospital', '5th Phase Yelahanka New Town', 'Ordinary', 'Running', 60, 'KA-01 F-2342', '507-D DOWN'),

('285MC YSTF-NES-DBP', '285-MC', '5th Phase Yelahanka New Town', 'Doddaballapura Bus Stand', 'Ordinary', 'Running', 60, 'KA-01 F-6754', '285-MC UP'),
('285-MC YSTF-NES-DBP', '285-MC', 'Doddaballapura Bus Stand', '5th Phase Yelahanka New Town', 'Ordinary', 'Running', 60, 'KA-01 F-6754', '285-MC DOWN'),

('G9 SBS-YSTF', 'G-9', '5th Phase Yelahanka New Town', 'Shivajinagara Bus Station', 'Vayu Vajra', 'Running', 60, 'KA-01 F-4544', 'G-9 DOWN'),
('G-9 SBS-YSTF', 'G-9', 'Shivajinagara Bus Station', '5th Phase Yelahanka New Town', 'Vayu Vajra', 'Running', 60, 'KA-01 F-4544', 'G-9 UP'),

('302-KLN-SBS', '302', '80 feet Road Kalyananagara', 'Shivajinagara Bus Station', 'Ordinary', 'Running', 60, 'KA-01 F-9090', '302 KLN-SBS UP'),
('302 KLN-SBS', '302', 'Shivajinagara Bus Station', '80 feet Road Kalyananagara', 'Ordinary', 'Running', 60, 'KA-01 F-9090', '302 SBS-KLN UP'),

('BC7C', 'BC-7C', '8th Mile Dasarahalli', '8th Mile Dasarahalli', 'Big Circle', 'Running', 60, 'KA-01 F-8980', 'BC-7C UP'),
('BC-7C', 'BC-7C', '8th Mile Dasarahalli', '8th Mile Dasarahalli', 'Big Circle', 'Running', 60, 'KA-01 F-8980', 'BC-7C UP'),

--('250-DD', '250-DD', '8th Mile Dasarahalli', '8th Mile Dasarahalli Arrival', 'Ordinary', 'Running', 60, "KA-01 F-6767"),


('MF25', 'MF-25', 'Thippennahalli', '8th Mile Dasarahalli', 'Ordinary', 'Running', 60, 'KA-01 F-7777', 'MF-25 DOWN'),
('MF-25', 'MF-25', '8th Mile Dasarahalli', 'Thippennahalli', 'Ordinary', 'Running', 60, 'KA-01 F-7777', 'MF-25 UP'),


('60A CLO-JNN', '60-A', '9th Block Jayanagara', 'Chandra Layout', 'Ordinary', 'Running', 60, 'KA-01 F-1111', '60-A CLO-JNN DOWN'),
('60-A CLO-JNN', '60-A', 'Chandra Layout', '9th Block Jayanagara', 'Ordinary', 'Running', 60, 'KA-01 F-1111', '60-A CLO-JNN UP'),

('237J', '237-J', '9th Block Jayanagara', 'Panchasheela Nagara', 'Ordinary', 'Running', 60, 'KA-01 F-2406', '237-J UP'),
('237-J', '237-J', 'Panchasheela Nagara', '9th Block Jayanagara', 'Ordinary', 'Running', 60, 'KA-01 F-2406', '237-J DOWN'),


('347-K', '347-K', 'AECS Layout Singasandra', 'KR Market', 'Ordinary', 'Running', 60, 'KA-01 F-5445','347-K DOWN'),
('347K', '347-K', 'KR Market', 'AECS Layout Singasandra', 'Ordinary', 'Running', 60, 'KA-01 F-5445','347-K UP'),

('347N', '347-N', 'AECS Layout Singasandra', 'Kempegowda Bus Station', 'Ordinary', 'Running', 60, 'KA-01 F-5877','347-N DOWN'),
('347-N', '347-N', 'Kempegowda Bus Station', 'AECS Layout Singasandra', 'Ordinary', 'Running', 60, 'KA-01 F-5877','347-N UP'),

('45G AGSLC-KBS', '45-G', 'AGS Layout Cross', 'Kempegowda Bus Station', 'Ordinary', 'Running', 60, 'KA-01 F-8787','45-G AGSLC-KBS UP'),
('45-G AGSLC-KBS', '45-G', 'Kempegowda Bus Station', 'AGS Layout Cross', 'Ordinary', 'Running', 60, 'KA-01 F-8787','45-G AGSLC-KBS UP'),

('401AK ABG-PSS', '401-AK', 'Abbigere', 'Peenya 2nd stage', 'Ordinary', 'Running', 60, 'KA-01 F-1986', '401-AK ABG-PSS UP'),
('401-AK ABG-PSS', '401-AK', 'Peenya 2nd stage', 'Abbigere', 'Ordinary', 'Running', 60, 'KA-01 F-1986', '401-AK DOWN'),

('V250SB', 'V-250SB', 'Acharya Institute of Technology', 'KR Market', 'Volvo', 'Running', 60,'KA-01 F-2387', 'V-250SB UP'),
('V-250SB', 'V-250SB', 'KR Market', 'Acharya Institute of Technology', 'Volvo', 'Running', 60,'KA-01 F-2387', 'V-250SB UP'),

('258N ASDW-VSD-KBS', '258-N', 'Adarshanagara Water Tank', 'Kempegowda Bus Station', 'Ordinary', 'Running', 60, 'KA-01 F-4540', '258-N ASDW-VSD-KBS UP'),
('258-N ASDW-VSD-KBS', '258-N', 'Kempegowda Bus Station', 'Adarshanagara Water Tank', 'Ordinary', 'Running', 60, 'KA-01 F-4540', '258-N UP'),

('Vivek_Test-14', 'Vivek_Test14', '10th Cross Lingadhiranahalli', '10th Cross Magadi Road', 'Test Route', 'Running', 60, 'KA-01 F-9898', 'Vivek_Test14 UP'),
('Vivek_Test14', 'Vivek_Test14', '10th Cross Magadi Road', '10th Cross Lingadhiranahalli', 'Test Route', 'Running', 60, 'KA-01 F-9898', 'Vivek_Test14 DOWN'),

('VLO1KGR', 'VLO1-KGR', '1st Block Vishweshwaraiah Layout', 'Kengeri Bus Station', 'Ordinary', 'Running', 60, 'KA-01 F-9999', 'VLS--3 UP'),
('VLO1-KGR', 'VLO1-KGR', 'Kengeri Bus Station', '1st Block Vishweshwaraiah Layout', 'Ordinary', 'Running', 60, 'KA-01 F-9999', 'VLO1-KGR DOWN'),

('2KVPJHE', '2KVP-JHE', 'Jalahalli East', '2nd stage Kuvempunagara', 'Ordinary', 'Running', 60, 'KA-01 F-1112','2KVP-JHE DOWN'),
('2KVP-JHE', '2KVP-JHE', '2nd stage Kuvempunagara', 'Jalahalli East', 'Ordinary', 'Running', 60, 'KA-01 F-1112','2KVP-JHE DOWN'),

('300E ADMC-KRPGH', '300-E', 'ADMC Quarters Office', 'KR Pura Govt Hospital', 'Ordinary', 'Running', 60, 'KA-01 F-2223','300-E ADMC-KRPGH UP'),
('300-E ADMC-KRPGH', '300-E', 'KR Pura Govt Hospital', 'ADMC Quarters Office', 'Ordinary', 'Running', 60, 'KA-01 F-2223','300-E ADMC-KRPGH DOWN'),

('4DYNGYHK', '401', 'Adishwara Bombay Dying', 'Yelahanka Old Town', 'Ordinary', 'Running', 60, 'KA-01 F-3786', '401 ABDYNG-YHK UP'),
('4DYNG-YHK', '401', 'Adishwara Bombay Dying', 'Yelahanka Old Town', 'Ordinary', 'Running', 60, 'KA-01 F-3786', '401 ABDYNG-YHK UP');
