@echo off
cls
echo "Inicializando Maven"
cd .\Projetos\api-imovel
echo "Clean Install api-imovel"
mvnw.cmd clean install
cd ..\..\
cd .\Projetos\api-informacoes-cidadao
echo "Clean Install api-informacoes-cidadao"
mvnw.cmd clean install
cd ..\..\
cd .\Projetos\api-security
echo "Clean Install api-security"
mvnw.cmd clean install
cd ..\..\
cd .\Projetos-Mock\api-integracao-safim
echo "Clean Install api-integracao-safim"
mvnw.cmd clean install
cd ..\..\
cd .\Projetos-Mock\api-integracao-stur
echo "Clean Install api-integracao-stur"
mvnw.cmd clean install
echo "Maven finalizado. Pacotes gerados"
cd ..\..\
echo "Gerando containers"
docker-compose up --build