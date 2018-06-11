update dipendenti 
set dipendenti.Cantina_idCantina =null and dipendenti.Magazzino_idMagazzino = null 
where Nome = 'maria' and Cognome = 'rossi'; 
update dipendenti 
set Magazzino_idMagazzino = 1 
where Nome = 'maria' and Cognome = 'rossi';