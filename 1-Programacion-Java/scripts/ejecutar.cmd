@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET nombre=Ejemplo
SET nombrepaquete=jcolonia.daw2022.ejemplos
SET args=

SET oldpath=%PATH%
SET PATH=c:\java\jdk17\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombrepaquete%.%nombre%
ECHO ---
ECHO.

java %nombrepaquete%.%nombre% %args%

:FIN
ECHO.
SET PATH=%oldpath%
PAUSE
