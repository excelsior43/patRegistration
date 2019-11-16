# Java Meetup Registration

## About the project

* Created exception mappers for UserNotFoundException and UserAlreadyRegisteredException to catch and handle these generically. 
* Created a create service and completed the code to make the registration flow work.
* Created registration.js to handle registration specific client-side handlers.
* Only extended the idea by keeping the underlying initial technology stack, wanted to move this solution on Vert.x asyncronous framework but could not move forward due to time constraint.


## RESTful Services
I have create CRUD methods for registration application, though only one is used by the frontend. All the test cases are written for all methods.

1. Created create registration
POST : http://localhost:8080/rest/registration

#### Request
```json
{
    "user": "simba",
    "password": "Test1234",
    "address": "AlMurabba, battah, Riyadh 11411",
    "email": "simba@onemail.com",
    "phone": "00966564565456"
}
```
#### Response

```json
{
    "user": "simba",
    "password": "Test1234",
    "address": "AlMurabba, battah, Riyadh 11411",
    "email": "simba@onemail.com",
    "phone": "00966564565456"
}
```

2. Read Registration

GET : http://localhost:8080/rest/registration/simba

#### Response
```json
{
    "user": "myUser2",
    "password": "myUser",
    "address": "myUser",
    "email": "myUser",
    "phone": "00966564565456"
}
```
3. Update Registration
PUT : http://localhost:8080/rest/registration/simba
#### Request
```json
{
    "user": "simba",
    "password": "Test1234",
    "address": "AlMurabba, battah, Riyadh 11411",
    "email": "simba@gmail.com",
    "phone": "001123456789"
}
```
#### Response
```json
{
    "user": "simba",
    "password": "Test1234",
    "address": "AlMurabba, battah, Riyadh 11411",
    "email": "simba@gmail.com",
    "phone": "001123456789"
}
```
4. Update Registration
DELETE : http://localhost:8080/rest/registration/simba

#### Response 
HTTP 204 No Content Found
