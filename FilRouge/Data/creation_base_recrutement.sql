-- Titre :             Création base cabinet recrutement version élèves.sql
-- Version :           1.0
-- Date création :     11 Janvier 2023
-- Date modification : 11 Janvier 2023
-- Auteur :            BOUAROUR Rani, HAVARD Julien
-- Description :       Script de création de la base de données pour le SI "gestion de cabinet de
--                     recrutement"
--                     Note : script pour PostgreSQL
--                     Ebauche du script : ne contient pour le moment que la table "entreprise".

-- +----------------------------------------------------------------------------------------------+
-- | Suppression des tables                                                                       |
-- +----------------------------------------------------------------------------------------------+


drop table if exists entreprise;
drop table if exists OffreEmploi;
drop table if exists MessageOffreEmploi;
drop table if exists MessageCandidature;
drop table if exists NiveauQualification;
drop table if exists Index_secteurActivite;
drop table if exists SecteurActivite;
drop table if exists Index_Candidature_secteurActivite;
drop table if exists Candidature;

-- +----------------------------------------------------------------------------------------------+
-- | Création des tables                                                                          |
-- +----------------------------------------------------------------------------------------------+
create table entreprise
(
  id              serial primary key,
  nom             varchar(50) not null,
  descriptif      text,
  adresse_postale varchar(30) -- Pour simplifier, adresse_postale = ville.
);
create table NiveauQualification
(
  id              serial primary key,
  intitule             varchar(50) not null
);

create table OffreEmploi
(
  id              serial primary key,
  titre             varchar(50) not null,
  profile_Recherche    varchar(50) not null,
  descriptif_Mission    text,
  dateDepot Date,
  id_entreprise   integer,
  constraint ID_entrepriseFK FOREIGN KEY (id_entreprise) REFERENCES entreprise(id),
  id_Qualification integer,
  constraint qualificationFK FOREIGN KEY (id_Qualification) REFERENCES NiveauQualification(id)
);
create table Candidature
(
  id             serial primary key,
  nom             varchar(50) not null,
  prenom          varchar(50) not null,
  dateNaissance   DATE,
  adressePostale             varchar(50) not null,
  adresseEmail               varchar(50) not null,
  cV                         boolean,
  dateDepot                  DATE
);


create table MessageOffreEmploi
(
  id             serial primary key, 
  dateEnvoi DATE,
  corps_message   text,
  id_Offre    integer,
  constraint OffreFK1 FOREIGN KEY (Id_Offre) REFERENCES OffreEmploi(id),
  id_Candidature    integer,
  constraint CandidatureFK1 FOREIGN KEY (Id_Candidature) REFERENCES Candidature(id)
);

create table MessageCandidature
(
  
  id             serial primary key,
  dateEnvoi DATE,
  corps_message   text,
  id_Offre    integer,
  constraint OffreFK2 FOREIGN KEY (Id_Offre) REFERENCES OffreEmploi(id),
  id_Candidature    integer,
  constraint CandidatureFK3 FOREIGN KEY (Id_Candidature) REFERENCES Candidature(id)
);


create table SecteurActivite
(
  id             serial primary key,
  intitule             varchar(100) not null
  
);

create table Index_secteurActivite
(
  idOffre              integer,
  idSecteur            integer,
   constraint ID_index_sect PRIMARY KEY (idOffre,idSecteur),
   FOREIGN KEY (idOffre) REFERENCES OffreEmploi(id),
   FOREIGN KEY (idSecteur) REFERENCES SecteurActivite(id)
);



create table Index_Candidature_secteurActivite
(
  idCandidature               integer,
  idSecteur                   integer,
  constraint ID_index_cand PRIMARY KEY (idCandidature,idSecteur),
  constraint CandidatureFK2 FOREIGN KEY (idCandidature) REFERENCES Candidature(id),
  constraint SecteurFK2 FOREIGN KEY (idSecteur) REFERENCES SecteurActivite(id)
);




-- +----------------------------------------------------------------------------------------------+
-- | Insertion de quelques données de pour les tests                                              |
-- +----------------------------------------------------------------------------------------------+

-- Insertion des entreprise

insert into entreprise values (nextval('entreprise_id_seq'),'IMT Atlantique','IMT Atlantique est une grande école pionnière en formation, en recherche et en entrepreneuriat et en tout plein de choses...','Plouzané');
insert into entreprise values (nextval('entreprise_id_seq'),'ENIB','Une école d''ingénieur juste à côté...','Plouzané');
insert into entreprise values (nextval('entreprise_id_seq'),'ENIB','Une école d''ingénieur juste à côté...','Plouzané');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Acme Inc.', 'Fabricant de produits de consommation', '123 Main St, Anytown USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Beta Corp.', 'Fournisseur de services informatiques', '456 Park Ave, Anycity USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Gamma Industries', 'Producteur d''équipements industriels', '789 Elm St, Anyville USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Delta Enterprises', 'Entreprise de construction', '321 Oak St, Anytown USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Epsilon LLC', 'Société de consulting', '654 Pine St, Anycity USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Zeta Inc.', 'Fabricant de produits électroniques', '987 Cedar St, Anyville USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Eta Co.', 'Entreprise de transport', '246 Birch St, Anytown USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Theta Corp.', 'Fournisseur de services financiers', '369 Maple St, Anycity USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Iota Inc.', 'Fabricant de matériel médical', '159 Willow St, Anyville USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Kappa LLC', 'Entreprise de services alimentaires', '753 Oak St, Anytown USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Lambda Co.', 'Fabricant de véhicules', '951 Pine St, Anycity USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Mu Inc.', 'Fournisseur de services de télécommunications', '753 Cedar St, Anyville USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Nu Corp.', 'Entreprise de biotechnologie', '951 Birch St, Anytown USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Xi LLC', 'Fabricant de produits chimiques', '753 Maple St, Anycity USA');
INSERT INTO entreprise (id, nom, descriptif, adresse_postale) VALUES (nextval('entreprise_id_seq'),'Omicron Co.', 'Entreprise de services de sécurité', '123 Willow St, Anyville USA');
-- Insertion des secteurs d'activité
INSERT INTO SecteurActivite (intitule) VALUES ('Achats/Logistique');
INSERT INTO SecteurActivite (intitule) VALUES ('Assistanat/Secrétariat');
INSERT INTO SecteurActivite (intitule) VALUES ('Agriculture');
INSERT INTO SecteurActivite (intitule) VALUES ('Agroalimentaire');
INSERT INTO SecteurActivite (intitule) VALUES ('Assurance');
INSERT INTO SecteurActivite (intitule) VALUES ('Audit/Conseil/Expertises');
INSERT INTO SecteurActivite (intitule) VALUES ('BTP/Immobilier');
INSERT INTO SecteurActivite (intitule) VALUES ('Commercial');
INSERT INTO SecteurActivite (intitule) VALUES ('Communication/Art/Média/Mode');
INSERT INTO SecteurActivite (intitule) VALUES ('Comptabilité');
INSERT INTO SecteurActivite (intitule) VALUES ('Direction Générale/Executive');
INSERT INTO SecteurActivite (intitule) VALUES ('Distribution/-Commerce');
INSERT INTO SecteurActivite (intitule) VALUES ('Electronique/Microélectronique');
INSERT INTO SecteurActivite (intitule) VALUES ('Environnement');
INSERT INTO SecteurActivite (intitule) VALUES ('Finance/Banque');
INSERT INTO SecteurActivite (intitule) VALUES ('Formation/Enseignement');
INSERT INTO SecteurActivite (intitule) VALUES ('Hôtellerie/Restauration/Tourisme');
INSERT INTO SecteurActivite (intitule) VALUES ('Industrie/Ingénierie/Production');
INSERT INTO SecteurActivite (intitule) VALUES ('Informatique');
INSERT INTO SecteurActivite (intitule) VALUES ('Juridique/Fiscal/Droit');
INSERT INTO SecteurActivite (intitule) VALUES ('Marketing');
INSERT INTO SecteurActivite (intitule) VALUES ('Public/Parapublic');
INSERT INTO SecteurActivite (intitule) VALUES ('Ressources Humaines');
INSERT INTO SecteurActivite (intitule) VALUES ('Santé/Social/Biologie/Humanitaire');
INSERT INTO SecteurActivite (intitule) VALUES ('Télécom/Réseaux');

-- Insertion des qualification

INSERT INTO NiveauQualification (intitule) VALUES ('CAP/BEP');
INSERT INTO NiveauQualification (intitule) VALUES ('Bac');
INSERT INTO NiveauQualification (intitule) VALUES ('Bac+3');
INSERT INTO NiveauQualification (intitule) VALUES ('Bac+5');
INSERT INTO NiveauQualification (intitule) VALUES ('Doctorat');

-- Insertion des offres d'emploi 

INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Ingénieur en développement logiciel', 'Expérience en développement Java', 'Travailler sur des projets de développement logiciel pour les entreprises', '2022-01-01', 1);
INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Directeur des ventes', 'Expérience en vente B2B', 'Gérer l équipe de vente et atteindre les objectifs de vente', '2022-02-01', 2);
INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Analyste financier', 'Expérience en analyse financière', 'Analyser les états financiers et les performances de l entreprise', '2022-03-01', 3);
INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Responsable des ressources humaines', 'Expérience en gestion de personnel', 'Gérer les processus de recrutement, de formation et de développement des employés', '2022-04-01', 4);
INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Ingénieur en mécanique', 'Expérience en conception mécanique', 'Concevoir et développer des produits mécaniques pour l industrie', '2022-05-01', 5);
INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Chef de projet informatique', 'Expérience en gestion de projet', 'Gérer les projets informatiques de l entreprise', '2022-06-01', 6);
INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Assistant administratif', 'Expérience en gestion administrative', 'Gérer les tâches administratives de l entreprise', '2022-07-01', 7);
INSERT INTO offre_emploi (titre, profile_recherche, descriptif_mission, date_depot, id_entreprise) VALUES ('Responsable de la logistique', 'Expérience en gestion de la chaîne d approvisionnement', 'Gérer lesprocessus logistiques de l entreprise, y compris la planification des livraisons et la gestion des stocks', '2022-08-01', 8);
INSERT INTO offre_emploi (titre, profile_recherche, descriptif_mission, date_depot, id_entreprise) VALUES ('Spécialiste en marketing numérique', 'Expérience en marketing en ligne', 'Gérer les campagnes de marketing en ligne de l entreprise', '2022-09-01', 9);
INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Ingénieur en robotique', 'Expérience en développement de robots', 'Concevoir et développer des robots pour l industrie', '2022-10-01', 10);
INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Directeur artistique', 'Expérience en design graphique', 'Gérer l équipe de design graphique et diriger les projets de création', '2022-11-01', 11);
INSERT INTO OffreEmploi (titre, profile_recherche, descriptif_mission, dateDepot, id_entreprise) VALUES ('Ingénieur en génie civil', 'Expérience en construction', 'Concevoir et superviser les projets de construction', '2022-12-01', 12);

-- Insertion des candidatures
INSERT INTO candidature (id, nom, prenom, dateNaissance, adressePostale, adresseEmail, cV, dateDepot) VALUES (nextval('candidature_id_seq'), 'John', 'Doe', '2000-01-01', '123 Main St, Anytown USA', 'johndoe@email.com', true, '2022-01-01');
INSERT INTO candidature (id, nom, prenom, dateNaissance, adressePostale, adresseEmail, cV, dateDepot) VALUES (nextval('candidature_id_seq'), 'Jane', 'Smith', '1995-02-01', '456 Park Ave, Anytown USA', 'janesmith@email.com', true, '2022-01-02');
INSERT INTO candidature (id, nom, prenom, dateNaissance, adressePostale, adresseEmail, cV, dateDepot) VALUES (nextval('candidature_id_seq'), 'Mike', 'Johnson', '1990-03-01', '789 Elm St, Anytown USA', 'mikejohnson@email.com', true, '2022-01-03');
INSERT INTO candidature (id, nom, prenom, dateNaissance, adressePostale, adresseEmail, cV, dateDepot) VALUES (nextval('candidature_id_seq'), 'Emily', 'Brown', '1985-04-01', '321 Oak St, Anytown USA', 'emilybrown@email.com', true, '2022-01-04');
INSERT INTO candidature (id, nom, prenom, dateNaissance, adressePostale, adresseEmail, cV, dateDepot) VALUES (nextval('candidature_id_seq'), 'David', 'Moore', '1980-05-01', '159 Pine St, Anytown USA', 'davidmoore@email.com', true, '2022-01-05');
INSERT INTO candidature (id, nom, prenom, dateNaissance, adressePostale, adresseEmail, cV, dateDepot) VALUES (nextval('candidature_id_seq'), 'Ashley', 'Taylor', '1975-06-01', '753 Cedar St, Anytown USA', 'ashleytaylor@email.com', true, '2022-01-06');
INSERT INTO candidature (id, nom, prenom, dateNaissance, adressePostale, adresseEmail, cV, dateDepot) VALUES (nextval('candidature_id_seq'), 'Michael', 'Anderson', '1970-07-01', '951 Birch St, Anytown USA', 'michaelanderson@email.com', true, '2022-01-07');