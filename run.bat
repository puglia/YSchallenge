echo BUILD PROJECT...
call mvn clean install -Dmaven.test.skip=true

echo BUILD DOCKER IMAGE
docker build -t yieldstreet1 .

mkdir ysfiles

echo RUNNING CONTAINER
docker run -p 8080:8080 -v /ysfiles:/var/www/ysfiles --env FILES_PATH=/var/www/ysfiles --name ys1 yieldstreet1
