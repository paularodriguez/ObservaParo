# language: es
Característica: Servicios REST

Escenario:Uso de un servicio REST para obtener una provincia por código
    
	Dado que tengo iniciada la aplicacion
	Cuando ejecuto un servicio REST para obtener una provincia por su código 01
	Entonces el contenido resultante contiene Araba/Álava
	
Escenario:Uso de un servicio REST para obtener el listado de comunidades autónomas
    
	Dado que tengo iniciada la aplicacion
	Cuando ejecuto un servicio REST para obtener el listado de comunidades autónomas
	Entonces el contenido resultante contiene Principado de Asturias
	
Escenario:Uso de un servicio REST para obtener una observación de un año determinado
    
	Dado que tengo iniciada la aplicacion
	Cuando 	ejecuto un servicio REST para obtener una observacion del año 2007
	Entonces el contenido resultante contiene 2007
	
Escenario:Uso de un servicio REST para obtener una observación de un mes determinado
    
	Dado que tengo iniciada la aplicacion
	Cuando 	ejecuto un servicio REST para obtener una observacion del mes ENERO
	Entonces el contenido resultante no contiene FEBRERO