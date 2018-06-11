/*quante bottiglie di vino lacella ci sono in magazzino */
use cantina;

 
select sum(NBottiglie) from deposita, vino
where VinoSfuso_Nome = 'lancella' and Vino_idVino=idVino;