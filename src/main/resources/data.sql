DROP TABLE IF EXISTS billionaires;

CREATE TABLE developer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  registered_at Date NOT NULL,
  instagram_username VARCHAR(50),
  twitter_username VARCHAR(50),
  dev_env VARCHAR(100),
  location  VARCHAR(50) NOT NULL
);
