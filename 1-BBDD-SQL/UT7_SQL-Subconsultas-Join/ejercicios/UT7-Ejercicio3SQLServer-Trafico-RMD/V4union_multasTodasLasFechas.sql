create view V4union_multasTodasLasFechas as

select Codigo, Agentes.Nombre as Nombre_Agen, Agentes.Apellido as Apellido_Agen, Fecha_Ingreso, Identificador, Fecha, 
Importe, Hora, Propietarios.DNI as DNI_Prop, Propietarios.Nombre as Nombre_Prop, Propietarios.Apellido as Apellido_Prop, Fecha_nacimiento, Direccion
FROM   Agentes INNER JOIN Multas ON Agentes.Codigo = Multas.Codigo_Agente LEFT OUTER JOIN
                         Vehiculos ON Multas.Matricula_Vehiculo = Vehiculos.Matricula inner join Propietarios
						 on Vehiculos.DNI_Propietario = Propietarios.DNI
union

select Codigo, Agentes.Nombre as Nombre_Agen, Agentes.Apellido as Apellido_Agen, Fecha_Ingreso, MultasActuales.Identificador as ID_MultasAct, 
MultasActuales.Fecha as Fecha_MultasAct, MultasActuales.Importe as Importe_MultasAct, MultasActuales.Hora as Hora_MultasAct, Propietarios.DNI as DNI_Prop, 
Propietarios.Nombre as Nombre_Prop, Propietarios.Apellido as Apellido_Prop, Fecha_nacimiento, Direccion

FROM   Agentes INNER JOIN MultasActuales ON Agentes.Codigo = MultasActuales.Codigo_Agente LEFT OUTER JOIN
                         Vehiculos ON MultasActuales.Matricula_Vehiculo = Vehiculos.Matricula inner join Propietarios
						 on Vehiculos.DNI_Propietario = Propietarios.DNI
