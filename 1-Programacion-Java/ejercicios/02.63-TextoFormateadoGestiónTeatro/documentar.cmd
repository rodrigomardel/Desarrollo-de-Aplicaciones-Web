@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20231127000

SET nombre= Documentación Gestión Registros Teatro
SET nombrepaquete=jcolonia.daw2023.teatrillo
SET rutapaquete=jcolonia\daw2023\teatrillo

SET oldpath=%PATH%
SET PATH=c:\java\jdk21\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombrepaquete%.%nombre%
ECHO ---
ECHO.

REM Descargar https://docs.oracle.com/en/java/javase/21/docs/api/element-list
REM ¿Descargar https://junit.org/junit5/docs/current/api/element-list?
javadoc -verbose ^
	-Xdoclint:all ^
	-d doc -sourcepath src ^
	-cp "lib/*" ^
	-overview src\overview.html ^
	-html5 ^
	-encoding utf-8 ^
	-docencoding utf-8 ^
	-charset utf-8 ^
	-locale es_ES ^
	-author ^
	-version ^
	-private ^
	-linksource ^
	-subpackages %nombrepaquete%

ECHO.
DIR doc\%rutapaquete%

:FIN
ECHO.
SET PATH=%oldpath%
PAUSE
