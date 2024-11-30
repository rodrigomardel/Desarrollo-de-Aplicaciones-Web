select nombre
from v3_multasAgentes
where importe in (

select max(importe)
from v3_multasAgentes)