select count(*) as 'N� viviendas', localidad
from View_3
group by localidad
having count(*)> 3