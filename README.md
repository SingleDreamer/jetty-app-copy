# jetty-app

Run as Java Application in your IDE/Editor/Terminal of choice.

To test GET method with curl (or Postman, Insomnia, etc.):

```
curl http://localhost:8081/api/task/taskyyyy
```
------> will return JSON ------>
```
{"todo":"You just did a GET for the task: taskyyyy"}
```

To test POST method with curl:

```
curl -H "Content-Type: application/json" -X POST -d '{"todo": "THIS IS THE BEST TASK POST EVER!"}' http://localhost:8081/api/task
```
------> will return TEXT ------>
```
You just did a POST for the task: THIS IS THE BEST TASK POST EVER!
```
