INSERT INTO room(price, capacity, type_class)
VALUES (1800.00, 2, 'GRAND'),
       (2100.25, 2, 'STANDARD'),
       (1800.00, 1, 'STANDARD'),
       (3100.355, 1, 'SUPERIOR'),
       (3800.785, 2, 'SUPERIOR'),
       (4100.00, 1, 'DELUXE'),
       (4900.00, 2, 'DELUXE'),
       (4200.245, 4, 'FAMILY'),
       (3300.00, 3, 'TRIPLE');

INSERT INTO client(phone, name, second_name)
VALUES ('890987844532', 'Елизавета', 'Лескина'),
       ('89743449912', 'Олег', 'Петров'),
       ('89823428809', 'Екатерина', 'Смирнова'),
       ('89189754655', 'Тимур', 'Кононов'),
       ('89195324408', 'Олеся', 'Туманова');

INSERT INTO registration(client_id, room_id, check_in, check_out)
VALUES ('36474c33-c77c-4ddd-9f41-9539f2f663f0', '8eb64486-43c8-4a36-9aef-63e9db38309a', '2022-09-23T12:00:45.511Z', '2022-09-26T14:00:45.511Z'),
       ('8b0fb676-889a-4fd7-84d1-2f40e671a0b6', '66ed3aea-54cf-4824-8fd4-2beff9b2a690', '2022-09-20T12:00:45.511Z', '2022-09-27T14:00:45.511Z'),
       ('4ae168ac-eddf-4c8f-96f1-c5e5c9a9eced', '3f46db28-631a-42ed-b635-144ae83818f6', '2022-09-20T12:00:45.511Z', '2022-09-27T14:00:45.511Z');
