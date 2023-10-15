create sequence travelorder_sequence start with 1 increment by 1;
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));

create sequence flight_sequence start with 1 increment by 1;
INSERT INTO Flight(id, travelOrderId, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 1, 'GRU', 'MCO');
INSERT INTO Flight(id, travelOrderId, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 2, 'BSB', 'JFK');
INSERT INTO Flight(id, travelOrderId, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 3, 'LAX', 'ATL');
INSERT INTO Flight(id, travelOrderId, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 4, 'LHR', 'MEX');
INSERT INTO Flight(id, travelOrderId, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 5, 'GIG', 'BSB');

