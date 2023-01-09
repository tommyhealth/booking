CREATE TABLE client (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    phone       VARCHAR(20)  UNIQUE,
    name        VARCHAR(100) NOT NULL,
    second_name VARCHAR(100) NOT NULL
);

CREATE TABLE room (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    price      DECIMAL      NOT NULL,
    capacity   INTEGER      NOT NULL,
    type_class VARCHAR(100) NOT NULL
);

CREATE TABLE registration (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    room_id   uuid REFERENCES room(id)   NOT NULL,
    client_id uuid REFERENCES client(id) NOT NULL,
    check_in  TIMESTAMP NOT NULL,
    check_out TIMESTAMP
);
