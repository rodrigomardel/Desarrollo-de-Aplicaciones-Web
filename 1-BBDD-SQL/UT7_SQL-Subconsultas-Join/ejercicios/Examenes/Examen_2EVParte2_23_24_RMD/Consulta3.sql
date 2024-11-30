select count(*) as 'Nº viviendas', localidad
from View_3
group by localidad
having count(*)> 3