CREATE TABLE Partida (
  id INT PRIMARY KEY AUTO_INCREMENT,
  dataHora DATETIME NOT NULL,
  mandante_id INT NOT NULL,
  visitante_id INT NOT NULL,
  FOREIGN KEY (mandante_id) REFERENCES Time(id),
  FOREIGN KEY (visitante_id) REFERENCES Time(id)
);