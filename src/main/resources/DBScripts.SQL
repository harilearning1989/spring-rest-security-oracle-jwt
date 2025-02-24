CREATE TABLE roles
(
    id   NUMBER GENERATED ALWAYS AS IDENTITY, -- Identity column for auto-increment
    name VARCHAR2(50) NOT NULL UNIQUE,
    CONSTRAINT PK_roles_id PRIMARY KEY (id)   -- Custom primary key name
);

INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_LEAD');
INSERT INTO roles (name) VALUES ('ROLE_HR');
INSERT INTO roles (name) VALUES ('ROLE_MANAGER');
INSERT INTO roles (name) VALUES ('ROLE_ASM');
INSERT INTO roles (name) VALUES ('ROLE_CEO');
INSERT INTO roles (name) VALUES ('ROLE_TRAINEE');
INSERT INTO roles (name) VALUES ('ROLE_ASSOCIATE');

CREATE TABLE users
(
    id         NUMBER GENERATED ALWAYS AS IDENTITY, -- Identity column for auto-increment
    username   VARCHAR2(50) NOT NULL UNIQUE,
    password   VARCHAR2(255) NOT NULL,
    enabled    NUMBER(1) DEFAULT 1,-- 1: enabled, 0: disabled
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_users_id PRIMARY KEY (id)         -- Custom primary key name
);

CREATE TABLE user_roles
(
    user_id NUMBER REFERENCES users (id) ON DELETE CASCADE,
    role_id NUMBER REFERENCES roles (id) ON DELETE CASCADE,
    CONSTRAINT PK_user_roles PRIMARY KEY (user_id, role_id) -- Custom composite primary key name
);