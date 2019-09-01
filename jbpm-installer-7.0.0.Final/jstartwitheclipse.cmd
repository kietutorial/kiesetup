echo off
call setant

set CMD=ant start.demo
echo .
echo CMD=%CMD%
echo .

%CMD%
