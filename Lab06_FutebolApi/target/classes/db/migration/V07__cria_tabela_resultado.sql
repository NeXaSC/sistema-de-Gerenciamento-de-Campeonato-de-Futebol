CREATE TABLE Resultado (
  id INT PRIMARY KEY AUTO_INCREMENT,
  partida_id INT,
  numGolsMandante INT NOT NULL,
  numGolsVisitante INT NOT NULL,
  FOREIGN KEY (partida_id) REFERENCES Partida(id)
);