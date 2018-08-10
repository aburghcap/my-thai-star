CREATE TABLE Special(
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  name VARCHAR(255),
  offer_id BIGINT,
  
  -- PackagePersonEmbeddable packagePerson;
  minPerson INTEGER,
  maxPerson INTEGER,

  specialPrice VARCHAR(255),
  CONSTRAINT PK_Special PRIMARY KEY(id)
);
INSERT INTO Special(modificationCounter, name, offer_id, minPerson, maxPerson) VALUES (0, 'Wedding day', 0, 6, 50); 
INSERT INTO Special(modificationCounter, name, offer_id, minPerson, maxPerson) VALUES (0, 'Diner for Two', 0, 2, 50); 
