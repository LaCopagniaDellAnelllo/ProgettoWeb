/*Selezionare il nome e l'indirizzo del magazzino in cui si trova il vino 'Terzarulo ' dell'anno '2016'.*/
 use cantina;
 
select m.idMagazzino, m.Nome, m.Via, m.CAP, m.Città, v.VinoSfuso_Nome
from (magazzino m join deposita  d on  idMagazzino = d.Magazzino_idMagazzino) join vino v on d.Vino_idVino = v.idVino
where v.VinoSfuso_Nome = 'Terzarulo' and  v. VinoSfuso_Anno = '2016' 