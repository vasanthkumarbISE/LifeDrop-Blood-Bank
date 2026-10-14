
@echo off
cd /d "%~dp0"
start "" http://localhost:8080
call mvn spring-boot:run
pause

