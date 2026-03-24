-- add manufacturers
INSERT INTO manufacturers (name, country) VALUES ('Boeing', 'USA') ON CONFLICT DO NOTHING;
INSERT INTO manufacturers (name, country) VALUES ('Airbus', 'France') ON CONFLICT DO NOTHING;
INSERT INTO manufacturers (name, country) VALUES ('Embraer', 'Brazil') ON CONFLICT DO NOTHING;

-- add airlines
INSERT INTO airlines (name, iata_code) VALUES ('SkyUp Airlines', 'SQP') ON CONFLICT DO NOTHING;
INSERT INTO airlines (name, iata_code) VALUES ('Ryanair', 'RYR') ON CONFLICT DO NOTHING;
INSERT INTO airlines (name, iata_code) VALUES ('Lufthansa', 'DLH') ON CONFLICT DO NOTHING;