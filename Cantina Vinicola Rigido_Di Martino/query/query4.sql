/*Seleziona il nome del cliente e la quantità di bottiglie comprate.*/

use cantina;

select c.nome, c.cognome,  count(i.NBottiglie) from cliente c, include i
