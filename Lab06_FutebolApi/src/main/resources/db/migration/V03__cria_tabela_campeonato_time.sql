CREATE TABLE campeonato_time (
  campeonato_id INT,
  time_id INT,
  PRIMARY KEY (campeonato_id, time_id),
  FOREIGN KEY (campeonato_id) REFERENCES Campeonato(id),
  FOREIGN KEY (time_id) REFERENCES Time(id)
);