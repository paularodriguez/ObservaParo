# language: es
Característica: Visitar la aplicación

Escenario:Iniciar la aplicación
    
	Dado que tengo arrancada la aplicacion
	Cuando voy a la pagina principal
	Entonces el titulo es Historical
	
Escenario:Navegar por la aplicación - Comunidades autónomas
    
	Dado que tengo arrancada la aplicacion
	Cuando voy a la pagina de comunidades autonomas
	Entonces el titulo es Autonomous Communities

Escenario:Navegar por la aplicación - Provincias
    
	Dado que tengo arrancada la aplicacion
	Cuando voy a la pagina de provincias
	Entonces el titulo es Provinces

Escenario:Navegar por la aplicación - Estadísticas mujeres
    
	Dado que tengo arrancada la aplicacion
	Cuando consulto las estadisticas de desempleo de mujeres
	Entonces el titulo es Total Mujeres

Escenario:Navegar por la aplicación - Estadísticas sector servicios
    
	Dado que tengo arrancada la aplicacion
	Cuando consulto las estadisticas del sector servicios
	Entonces el titulo es Sector Servicios