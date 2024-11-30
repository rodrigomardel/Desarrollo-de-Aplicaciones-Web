@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET nombre=DrumFest24.jar

ECHO %nombre%
ECHO ---
ECHO.

java -jar %nombre%

:FIN
ECHO.
PAUSE
