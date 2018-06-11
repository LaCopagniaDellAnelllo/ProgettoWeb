/* Selezionare il totale bottiglie per ogni magzzino*/

use cantina;

 

select idMagazzino, M.nome, sum(D.NBottiglie),Capacità as NBottiglie from magazzino M JOIN deposita D ON M.idMagazzino = D.Magazzino_idMagazzino group by m.nome
;