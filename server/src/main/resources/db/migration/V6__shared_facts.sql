CREATE TABLE shared_url_rev (
    version             int PRIMARY KEY,
    description         varchar(255) NOT NULL,
    created_on          timestamp NOT NULL
);

INSERT INTO shared_url_rev (version, description, created_on) VALUES (1, 'initial', '2018-06-25');

CREATE TYPE share_method AS ENUM ('email', 'facebook', 'twitter');
CREATE TABLE shared_facts (
    shared_by           int REFERENCES account (id), --if NULL, shared by anonymous
    title               varchar(255),
    foundation_version  int NOT NULL REFERENCES foundation_rev(version),
    url_version         int NOT NULL REFERENCES shared_url_rev(version),
    method              share_method NOT NULL,
    fact_slug           varchar(255) NOT NULL,
    highlight_start     decimal(8, 3), --up to 99999.999
    highlight_end       decimal(8, 3),
    view_start          decimal(8, 3),
    view_end            decimal(8, 3)
);
