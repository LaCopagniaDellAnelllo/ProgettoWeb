/* Selezionare i dettagli delle 5 bottiglie di vino più vecchie nel magazzino mag1.*/
 use cantina ;
 
 select v.* from magazzino m, vino v order by v.VinoSfuso_Anno desc limit 5
 ;
 