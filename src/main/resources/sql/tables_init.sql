CREATE TABLE client
(
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    phone CHARACTER VARYING (20) NOT NULL,
    name CHARACTER VARYING(100) NOT NULL,
    second_name CHARACTER VARYING(100) NOT NULL
);

CREATE TABLE room
(
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    client_id uuid REFERENCES client (id),
    price DECIMAL NOT NULL,
    capacity INTEGER NOT NULL,
    type_class CHARACTER VARYING(100) NOT NULL,
    check_in DATE,
    check_out DATE
);