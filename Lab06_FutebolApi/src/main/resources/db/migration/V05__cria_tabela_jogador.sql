CREATE TABLE Jogador (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(60) NOT NULL,
  dataDeNascimento DATE NOT NULL,
  altura FLOAT NOT NULL,
  time_id INT,
  FOREIGN KEY (time_id) REFERENCES Time(id)
);