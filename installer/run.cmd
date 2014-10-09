@echo off
setlocal

cd /d "%~dp0"

setlocal EnableDelayedExpansion
for /L %%n in (1 1 500) do if "!__cd__:~%%n,1!" neq "" set /a "len=%%n+1"
setlocal DisableDelayedExpansion

set CP=.
for /r ./lib %%V IN (*.jar) DO call :jarmunge "%%V"
call :pathmunge .\resources
call :pathmunge .\conf

start javaw -Xmx256m -cp %CP% com.topcoder.umltool.deploy.UMLToolDeploy %1 %2 %3 %4

endlocal
goto :eof

:pathmunge
set CP=%CP%;%1
goto :eof

:jarmunge
set absPath=%1
setlocal EnableDelayedExpansion
set "relPath=!absPath:~%len%!"
set path=".!relPath!
endlocal & set CP=%CP%;%path%
