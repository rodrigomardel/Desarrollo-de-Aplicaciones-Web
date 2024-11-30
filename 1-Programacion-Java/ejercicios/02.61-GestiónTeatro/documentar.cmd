@ECHO OFF

ECHO Teatrillo (Documentación Javadoc)
ECHO =================================
ECHO.

REM javadoc -d doc -sourcepath src src\jcolonia\daw2023\teatrillo\*.java
javadoc -d doc ^
		-sourcepath src ^
		-subpackages jcolonia.daw2023.teatrillo ^
		-author ^
		-version ^
		-private

DIR /s /b doc