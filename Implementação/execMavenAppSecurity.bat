@echo off
cls
echo "Inicializando Maven"
cd .\Projetos\api-security
echo "Clean Install api-security"
mvnw.cmd clean install