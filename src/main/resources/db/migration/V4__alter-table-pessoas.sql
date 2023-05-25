ALTER TABLE pessoas
ADD COLUMN familia_id BIGINT,
ADD CONSTRAINT fk_familia FOREIGN KEY (familia_id) REFERENCES familias(id);