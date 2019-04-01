INSERT INTO role (name)
VALUES
  ('ROLE_MC'),
  ('ROLE_MM'),
  ('ROLE_S'),
  ('ROLE_ADMIN');

INSERT INTO supplier (name, status, lead_time, performance)
VALUES
  ('Supplier A', 'CLEAR', 24, 'Good'),
  ('Supplier B', 'BLOCKED', 48, 'Average'),
  ('Supplier C', 'PENDING', 36, 'Poor');

INSERT INTO supplier_contact (supplier_id, phone, email, location_main, location_delivery, location_collection)
VALUES
(1, '0311234567', 'supplier_a@gmail.com', '123 York Street Negombo', '123 Street Negombo', '123 York Negombo'),
(2, '0111234567', 'supplier_b@gmail.com', '456 Marine Drive Kandy', '456 Drive Kandy', '456 Marine Kandy'),
(3, '0911234567', 'supplier_c@gmail.com', '789 Alfred Road Colombo', '789 Road Colombo', '789 Alfred Colombo');

INSERT INTO item (supplier_id, name, price, quantity, description)
VALUES
  (1, 'Seat', 250, 22, 'Mountain Bicycle Seat'),
  (1, 'Handle', 500, 30, 'Mountain Bicycle Handle'),
  (2, 'Tyre', 650, 35, 'Mountain Bicycle Tyre'),
  (3, 'Brake', 400, 50, 'Mountain Bicycle Brake');

INSERT INTO item_reorder (item_id, level, quantity)
VALUES
  (1, 50, 250),
  (2, 100, 300),
  (3, 75, 350),
  (4, 100, 450);