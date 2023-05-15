## Step to run
```
$npm install -g newman
$newman


$newman run TDD.postman_collection.json
```

Run with reporter
```
$npm install -g newman-reporter-html
$newman run -r cli,json,junit,html  TDD.postman_collection.json
```
