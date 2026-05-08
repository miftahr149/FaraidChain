
@echo off
echo "Compiling project"
call mvn clean package
docker compose -f docker-composer.yaml up --build -d
echo "Compiling complete"