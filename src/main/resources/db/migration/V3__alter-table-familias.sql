ALTER TABLE familias
ADD COLUMN pessoa_id BIGINT,
ADD CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoas(id);