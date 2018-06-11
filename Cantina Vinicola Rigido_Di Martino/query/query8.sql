/*Calcolare e dare in output il fatturato mensile  dell'azienda.*/
use cantina;

select sum(Importo), sum(NBottiglie)
from ordine o join include i on o.idOrdine = i.Ordine_idOrdine
where o.data between '2017-09-01' and '2017-10-01'
;