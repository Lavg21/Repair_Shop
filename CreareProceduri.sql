DELIMITER // 

CREATE PROCEDURE cerinta3a()
BEGIN
SELECT id_d AS ID, data_introducere, aparat, simptome, defect, data_constatare, data_finalizare, durata, manopera_ora, total, id_client, id_depanator
  FROM Deviz  
     WHERE total > 100 AND data_introducere > '2021-01-01'
         ORDER BY data_introducere;
END // 
DELIMITER ;

DELIMITER // 

CREATE PROCEDURE cerinta3b()
BEGIN
SELECT id_p AS ID, descriere, fabricant, cantitate_stoc, pret_c AS PRET
  FROM Piesa  
    WHERE cantitate_stoc = 0
         ORDER BY descriere DESC, fabricant;
END // 
DELIMITER ;

DELIMITER // 

CREATE PROCEDURE cerinta4a()
BEGIN
SELECT id_d AS ID, descriere, fabricant, pret_c AS "PRET CATALOG", pret_r AS "PRET REAL"
  FROM Piesa INNER JOIN  Piesa_Deviz ON Piesa.id_p = Piesa_Deviz.id_p
    WHERE Pret_c = 0.9*pret_r;
END // 
DELIMITER ;

DELIMITER // 

CREATE PROCEDURE cerinta4b()
BEGIN
SELECT p1.id_p AS "PRIMA PIESA", p2.id_p AS "A DOUA PIESA", p1.descriere AS "DESCRIERE 1", p1.fabricant AS "FABRICANT 1", p2.descriere AS "DESCRIERE 2", p2.fabricant AS "FABRICANT 2"
  FROM Piesa p1, Piesa p2
    WHERE p1.id_p != p2.id_p AND p1.descriere = p2.descriere AND p1.fabricant != p2.fabricant
    LIMIT 1;
END // 
DELIMITER ;

DELIMITER // 

CREATE PROCEDURE cerinta5a()
BEGIN
SELECT d.id_d, d.data_introducere, d.aparat, d.simptome, d.defect, d.data_constatare, d.data_finalizare, d.durata, d.manopera_ora, d.total, d.id_client, d.id_depanator
  FROM Deviz d, Piesa p1, Piesa_Deviz p2
    WHERE d.id_d = p2.id_d AND p1.id_p = p2.id_p AND p1.id_p IN (SELECT p.id_p FROM Piesa p, Piesa_Deviz pd WHERE p.id_p = pd.id_p AND pd.pret_r < p.pret_c);
END // 
DELIMITER ;

DELIMITER // 

CREATE PROCEDURE cerinta5b()
BEGIN
SELECT * FROM Deviz 
    WHERE data_introducere LIKE '2021%' AND total >= ALL (SELECT total FROM Deviz);
END // 
DELIMITER ;

DELIMITER // 

CREATE PROCEDURE cerinta6a()
BEGIN
SELECT p.nume AS nume_depanator, sel.CATE_DEVIZE
FROM Persoana p 
INNER JOIN (SELECT d.id_depanator AS id_dep, COUNT(d.id_depanator) AS CATE_DEVIZE
            FROM Persoana p 
            INNER JOIN Deviz d ON p.id = d.id_depanator
            GROUP BY d.id_depanator) 
sel ON sel.id_dep = p.id;
END // 
DELIMITER ;

DELIMITER // 

CREATE PROCEDURE cerinta6b()
BEGIN
SELECT DISTINCT sel2.descriere, sel2.fabricant, sel2.cantitate_totala
FROM (SELECT p.id_p AS id_piesa, p.descriere AS descriere, p.fabricant AS fabricant, sel.cantitate_totala
      FROM Piesa p 
      INNER JOIN
      (SELECT pd.id_p AS id_piesa, SUM(pd.cantitate) AS cantitate_totala
       FROM Piesa_Deviz pd
      INNER JOIN Piesa p ON pd.id_p = p.id_p
      GROUP BY pd.id_p) sel ON sel.id_piesa = p.id_p) sel2, Deviz d
   WHERE d.data_introducere LIKE '2021%';
END // 
DELIMITER ;

CALL cerinta6b;

