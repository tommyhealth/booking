INSERT INTO room(id, price, capacity, type_class)
VALUES ('4ad6d27d-eb3d-4dad-9c0e-03e8529d163e', 1800.00, 2, 'GRAND'),
       ('36474c33-c77c-4ddd-9f41-9539f2f663f0', 2100.25, 2, 'STANDARD'),
       ('8b0fb676-889a-4fd7-84d1-2f40e671a0b6', 1800.00, 1, 'STANDARD'),
       ('4ae168ac-eddf-4c8f-96f1-c5e5c9a9eced', 3100.355, 1, 'SUPERIOR'),
       ('3f46db28-631a-42ed-b635-144ae83818f6', 3800.785, 2, 'SUPERIOR'),
       ('66ed3aea-54cf-4824-8fd4-2beff9b2a690', 4100.00, 1, 'DELUXE'),
       ('8eb64486-43c8-4a36-9aef-63e9db38309a', 4900.00, 2, 'DELUXE'),
       ('255d6825-5e41-4e96-943f-7411c48e1879', 4200.245, 4, 'FAMILY'),
       ('4c015d64-facb-402c-a61f-a3c88c307e09', 3300.00, 3, 'TRIPLE');

INSERT INTO client(id, phone, name, second_name)
VALUES ('58b1fea4-6ab3-4e44-b283-000936228d79','89098784453', 'Елизавета', 'Лескина'),
       ('19a4df8d-1194-404d-ae17-bfefa9cc9311','89743449912', 'Олег', 'Петров'),
       ('2dcf9701-92e3-41ba-a917-2adb824753d2','89823428809', 'Екатерина', 'Смирнова'),
       ('06c62f69-8851-4697-84e0-80ed9e9a37ea','89189754655', 'Тимур', 'Кононов'),
       ('e8a8be93-19f0-4c98-8f9e-dd792da1a04f','89195324408', 'Олеся', 'Туманова');

INSERT INTO registration(id, client_id, room_id, check_in, check_out)
VALUES ('dbd6131e-1f61-47b3-be08-6a21a489f54c','58b1fea4-6ab3-4e44-b283-000936228d79', '4ad6d27d-eb3d-4dad-9c0e-03e8529d163e', '2022-09-23T12:00:45.511Z', '2022-09-26T14:00:45.511Z'),
       ('108c453a-d582-4d66-bf65-c2dcc1b11034','19a4df8d-1194-404d-ae17-bfefa9cc9311', '36474c33-c77c-4ddd-9f41-9539f2f663f0', '2022-09-20T12:00:45.511Z', '2022-09-27T14:00:45.511Z'),
       ('db9077b0-b584-4c84-99c9-0b168f96b3bd','2dcf9701-92e3-41ba-a917-2adb824753d2', '8b0fb676-889a-4fd7-84d1-2f40e671a0b6', '2022-09-20T12:00:45.511Z', '2022-09-27T14:00:45.511Z');
