# MyBooks

![Demo of application](demo.gif)

## Run Application

1. Create `.env` file, see [.env.example](.env.example).
2. Set VM options: `-DMYSQL_DATABASE=db -DMYSQL_USER=user -DMYSQL_PASSWORD=pass`.
3. Run MySQL container.

```shell
docker-compose up
```

4. Run project in the selected IDE.