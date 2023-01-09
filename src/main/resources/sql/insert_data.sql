insert into room(id, price, capacity, type_class)
values (1800.00, 2, 'GRAND'),
       (2100.25, 2, 'STANDARD'),
       (1800.00, 1, 'STANDARD'),
       (3100.355, 1, 'SUPERIOR'),
       (3800.785, 2, 'SUPERIOR'),
       (4100.00, 1, 'DELUXE'),
       (4900.00, 2, 'DELUXE'),
       (4200.245, 4, 'FAMILY'),
       (3300.00, 3, 'TRIPLE');

 insert into client(phone, name, second_name)
 values ('890987844532', 'Елизавета', 'Лескина'),
        ('89743449912', 'Олег', 'Петров'),
        ('89823428809', 'Екатерина', 'Смирнова'),
        ('89189754655', 'Тимур', 'Кононов'),
        ('89195324408', 'Олеся', 'Туманова');

 insert into registration(room_id, check_in, check_out)
 values ('71733bae-4dfa-4622-bc96-268b8c798f5e', '2022-09-23T12:00:45.511Z', '2022-09-26T14:00:45.511Z'),
        ('9bac8820-7651-440d-a2eb-a17b468c5527', '2022-09-20T12:00:45.511Z', '2022-09-27T14:00:45.511Z'),
        ('aec260b3-c3d2-4e10-bfe3-ff1c2f50d9d8', '2022-09-20T12:00:45.511Z', '2022-09-27T14:00:45.511Z');