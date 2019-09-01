echo off
call setant

set CMD=ant start.eclipse
echo .
echo CMD=%CMD%
echo .
%CMD%