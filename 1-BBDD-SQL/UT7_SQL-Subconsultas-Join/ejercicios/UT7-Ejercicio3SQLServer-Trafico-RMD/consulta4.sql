select Nombre_Agen, Apellido_Agen, Fecha_Ingreso, Importe, Hora
from V4union_multasTodasLasFechas
where Importe>500 or Hora<'19:00'