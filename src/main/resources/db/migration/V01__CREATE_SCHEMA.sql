 /*
CREATE DATABASE FRAUDE
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE FRAUDE
    IS 'default administrative connection database';
*/
 
--DEV
-- CREATE SCHEMA IF NOT EXISTS FRDM AUTHORIZATION postgres;
-- GRANT ALL ON SCHEMA FRDM TO postgres;

--PROD
CREATE SCHEMA IF NOT EXISTS FRDM AUTHORIZATION gsvkxjhj;
GRANT ALL ON SCHEMA FRDM TO gsvkxjhj;