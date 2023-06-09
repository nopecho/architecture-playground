CREATE TABLE IF NOT EXISTS "domain_user" (
    id BIGINT PRIMARY KEY,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    last_modified_at TIMESTAMPTZ DEFAULT NOW(),
    version BIGINT NOT NULL
);