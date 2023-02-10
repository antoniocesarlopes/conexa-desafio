
# Back-end Challenge

## Challenge 1

REST API that returns a listing of The Star Wars Movies using the https://swapi.dev/ API that has Luke Skywalker as a character involved.




### Deployment

To deploy this project run

```bash
  docker run --rm -d -p 9090:9090 antoniocesarlopes/desafio01:latest
```


### API Reference

#### Get all Luke Skywalker's Star Wars films

```http
  GET localhost:9090/api/films
```

#### Get films with filters

```http
  GET /api/films?page=1&size=10&title=Empire&episode=5
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `page`      | `number` | **Not Required**. page start (default value = 1)|
| `size`      | `number` | **Not Required**. page size (default value = 10)|
| `title`      | `string` | **Not Required**. filter by title |
| `episode`      | `number` | **Not Required**. filter by episode |




## Challenge 2

Application that uses the API developed in Challenge 1 as data source and inserts another fictitious item in the movie list.
When running, the movies persisted in the h2 database are displayed on the console
### Deployment

To deploy this project run

```bash
  docker run --rm -p 8080:8080 antoniocesarlopes/desafio02:latest
```


## Authors

- [@antoniocesarlopes](https://www.linkedin.com/in/antoniocesarlopes/)

