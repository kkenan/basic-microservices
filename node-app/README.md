# Simple NodeJs Based App

## Requirements

The following is a list of requirements:
 - node `v9.9.0`
 - npm `5.6.0`

## Description

This is a simple node.js based app that exposes following endpoints:

```
GET /node/api/v1/result
```

This endpoint returns the following JSON:

```json
{
  "data": "Hello world from node app"
}

```

## Running

To run the app, execute:

```
node index.js
```

The app will listen on port `8081`.
