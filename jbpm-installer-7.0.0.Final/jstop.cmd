echo off
cls
call setant

set CMD=ant stop.demo
echo .
echo CMD=%CMD%
echo .
%CMD%
