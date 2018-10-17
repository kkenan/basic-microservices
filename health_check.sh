#!/usr/bin/env bash

if [ ! $(which curl) ]; then
  echo "no 'curl' available, please install it and rerun the script..."
  exit 1
fi

SPRING_HOST='localhost'
SPRING_PORT=8080
NODE_HOST='localhost'
NODE_PORT=8081
CHECKS_STATUS=0

function GET() {
  curl -s -i -X GET http://$1:$2/$3 | head -n 1 | awk '{ print $2 }'
}

function CHECK_INFO() {
  echo "Response from '$1' $2 API [$3]"
}

# Check spring service
APIs=( 'java/api/v1/status' 'java/api/v1/node' )
for api in "${APIs[@]}"
do
  if [[ '200' = $(GET $SPRING_HOST $SPRING_PORT $api) ]]; then
    response='OK'
  else
    response='FAILED'
    CHECKS_STATUS=1
  fi
  CHECK_INFO 'spring service' $api $response
done

# Check node service
api='node/api/v1/result'
if [[ '200' = $(GET $NODE_HOST $NODE_PORT $api) ]]; then
  response='OK'
else
  response='FAILED'
  CHECKS_STATUS=1
fi
CHECK_INFO 'node service' $api $response

if [[ $CHECKS_STATUS = '0' ]]; then
  echo -e "\nAll checks passed. Congrats!"
else
  echo -e "\nSome checks failed!!!"
  exit 1
fi