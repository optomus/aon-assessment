INSERT INTO insurer (id, insurer_name) VALUES (1, 'Insurer1');

INSERT INTO insurer (id, insurer_name) VALUES (2, 'Insurer2');
INSERT INTO exclusion_criteria (id, criteria_code, criteria_value, insurer_id)
VALUES (1, 'POST_CODES', '2000, 2001', 2);
INSERT INTO exclusion_criteria (id, criteria_code, criteria_value, insurer_id)
VALUES (2, 'OCCUPATIONS', 'Butcher', 2);

INSERT INTO insurer (id, insurer_name) VALUES (3, 'Insurer3');
INSERT INTO exclusion_criteria (id, criteria_code, criteria_value, insurer_id)
VALUES (3, 'POST_CODES', '2000', 3);
INSERT INTO exclusion_criteria (id, criteria_code, criteria_value, insurer_id)
VALUES (4, 'OCCUPATIONS', 'Butcher, Plumber', 3);
INSERT INTO exclusion_criteria (id, criteria_code, criteria_value, insurer_id)
VALUES (5, 'MIN_TURNOVER', 200000, 3);

INSERT INTO insurer (id, insurer_name) VALUES (4, 'Insurer4');
INSERT INTO exclusion_criteria (id, criteria_code, criteria_value, insurer_id)
VALUES (6, 'MIN_TURNOVER', 400000, 4);
