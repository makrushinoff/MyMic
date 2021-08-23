CREATE TABLE IF NOT EXISTS users
(
    id         UUID    NOT NULL PRIMARY KEY default gen_random_uuid(),
    first_name VARCHAR NOT NULL,
    last_name  VARCHAR NOT NULL,
    email      VARCHAR NOT NULL,
    birth_date DATE    NOT NULL,
    role       VARCHAR    NOT NULL,
    username   VARCHAR NOT NULL,
    password   VARCHAR NOT NULL,
    is_enabled BOOLEAN
);

CREATE TABLE IF NOT EXISTS post
(
    id      UUID    NOT NULL PRIMARY KEY default gen_random_uuid(),
    title   varchar not null,
    message VARCHAR NOT NULL,
    user_id UUID    NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id)
);