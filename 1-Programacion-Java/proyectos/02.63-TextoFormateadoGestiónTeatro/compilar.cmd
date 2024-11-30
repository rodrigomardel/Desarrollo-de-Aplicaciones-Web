@ECHO OFF

ECHO Teatrillo (compilación)
ECHO =======================
ECHO.

javac -d bin -sourcepath src src\jcolonia\daw2023\teatrillo\Teatrillo.java

DIR /s /b bin\jcolonia\daw2023\teatrillo