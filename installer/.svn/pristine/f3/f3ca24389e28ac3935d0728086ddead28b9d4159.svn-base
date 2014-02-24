@echo off
setlocal

cd /d "%~dp0"

set CP=.
for /r ./lib %%V IN (*.jar) DO call :pathmunge "%%V"
call :pathmunge .\resources
call :pathmunge .\conf

start javaw -Xmx256m -cp %CP% com.topcoder.umltool.deploy.UMLToolDeploy %1 %2 %3 %4

endlocal
goto :eof

:pathmunge
set CP=%CP%;%1
