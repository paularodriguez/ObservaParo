# language: es
Característica: Analizar hojas excel

Escenario: Obtener observaciones excel

    Dado que obtengo el fichero excel evolparoseries.xls
    Cuando leo las observaciones
    Entonces el año de la primera observacion es 2005

Escenario: Obtener valores observaciones excel

    Dado que obtengo el fichero excel evolparoseries.xls
    Cuando leo las observaciones
    Entonces el valor de la primera observacion es 2176599 

Escenario: Obtener provincias

    Dado que obtengo el fichero excel list-pro.xls
    Cuando leo las provincias
    Entonces el numero de provincias es 52
    
Escenario: Obtener comunidades autónomas

    Dado que obtengo el fichero excel list-pro.xls
    Cuando leo las comunidades autonomas
    Entonces el numero de comunidades es 19
