select count(*) as 'N� de pisos'
from view_5
where garaje like 'no' and ascensor like 'si'
group by localidad