# springBootTest
A spring boot test application using Hibernate to connect with a mySQL DB

The application starts server at http://localhost:8080/userService

The services are avaible to the following routes:
* GET '/api/v1/all' give all the users
* GET '/api/v1/user/{id}' give the user associated to the id
* DELETE '/api/v1/user/{id}' delete the user associated to the id
* POST '/api/v1/user' create a new user based on the information putted on the request body with this structure(id can be set to void)
```json
{       
        "id":"",
        "username": "",
        "firstName": "",
        "lastName": "",
        "mail": "",
        "date": ""
}
```
