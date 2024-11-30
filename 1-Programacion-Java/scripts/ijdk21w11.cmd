@ECHO OFF
CHCP 65001 > NUL

ECHO Entorno JDK21
ECHO =============
ECHO.

SET PS1=JDK21
SET PROMPT=$e[0;33m$c%PS1%$f$s$e[0;32m$p$g$e[m$s

SET PATH=c:\java\jdk21\bin;%PATH%

javac -version

SET CLASSPATH=bin;

SET JAVA_TOOL _OPTIONS=-Dfile.encoding=UTF-8

ECHO PATH=%PATH%