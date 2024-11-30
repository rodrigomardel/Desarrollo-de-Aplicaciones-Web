select localidad, precioalquiler
from view_2
where fecha_inicio < '2024-01-01' and precioalquiler in(

select min(precioalquiler)
from view_2
group by localidad)