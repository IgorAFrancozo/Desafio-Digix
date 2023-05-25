CREATE TABLE familias (
    id BIGINT NOT NULL AUTO_INCREMENT,
    renda_total DECIMAL(10, 2) NOT NULL,
    dependentes INT NOT NULL,
    PRIMARY KEY(id)
);
