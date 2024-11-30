select direccion, nombre
from view_1
where localidad like 'burgos' and Nombre is not null and precioventa = (
select max(precioventa)
from view_1 )