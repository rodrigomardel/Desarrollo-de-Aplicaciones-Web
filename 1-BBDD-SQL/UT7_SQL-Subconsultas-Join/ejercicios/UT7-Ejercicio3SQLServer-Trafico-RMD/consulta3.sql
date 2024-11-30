select count(identificador) as 'Nº multas - Ag.(16,18 y 10)'
from v3_multasAgentes
where codigo in ('16','18','10')