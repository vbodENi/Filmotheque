create table genres (
    id int primary key,
    libelle varchar(50) not null unique
);

INSERT INTO [dbo].[genres]
([id],[libelle])
VALUES (1,'Animation'),(2,'Animation'),(3,'Documentaire'),(4,'Action'),(5,'Comédie')