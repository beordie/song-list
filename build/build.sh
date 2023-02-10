commit_id=`git log -n 1 | head -n 1 | sed -e 's/^commit //' | head -c 8`
if [ ${#commit_id} -ne 8 ];then
    echo "!!! ERROR: get commit log short id fail"
    exit 1
fi

date_string=`date +%Y%m%d`

# cp ../eureka/target/eureka-1.0-SNAPSHOT.jar ./jar
# cp ../gateway/target/gateway-1.0-SNAPSHOT.jar ./jar
# cp ../recommend/target/recommend-1.0-SNAPSHOT.jar ./jar
# cp ../song/target/song-1.0-SNAPSHOT.jar ./jar
# cp ../user/target/user-1.0-SNAPSHOT.jar ./jar
# cp ../user/target/activity-1.0-SNAPSHOT.jar ./jar

docker build -f ./Dockerfile-eureka beordie-eureka:${commit_id}-${date_string} .
docker build -f ./Dockerfile-gateway beordie-gateway:${commit_id}-${date_string} .
docker build -f ./Dockerfile-recommend beordie-recommend:${commit_id}-${date_string} .
docker build -f ./Dockerfile-song beordie-song:${commit_id}-${date_string} .
docker build -f ./Dockerfile-user beordie-user:${commit_id}-${date_string} .
docker build -f ./Dockerfile-activity beordie-activity:${commit_id}-${date_string} .