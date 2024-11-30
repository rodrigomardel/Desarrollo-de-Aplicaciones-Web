@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET nombre=Ensayo4DConjunto
SET nombrepaquete=jcolonia.daw2023.g4d
SET rutapaquete=jcolonia\daw2023\g4d

SET oldpath=%PATH%
SET PATH=c:\java\jdk21\bin;%PATH%
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
