Spring MVC web api

Assumptions:
Full Name comes under one field:
    - I thought it wouldn't be recommended to make first Name and last names as some users could have middle names.
    - I was stuck between developing a full spring MVC with a front end and then just a REST API. I went with the second option.

The database is not pre-populated!

To post a request by using json in the format of:

{
    "fullName": "Ibrahim Ayanbunmi",
    "email": "ibrahim-ayanbunmi@live.co.uk",
    "password": "12345",
    "phoneNumber": "01234567890",
    "department": "Software",
    "jobTitle": "Engineering"
}

The requests will be posted to http://localhost:8080/api/users/{id}

Using the postman app would be the easiest way to post and get requests.

--------------------------------------------------------------------------------------
Github: https://github.com/Ibrawin/Spring-MVC-API

Circle CI: https://app.circleci.com/pipelines/github/Ibrawin/Spring-MVC-API?branch=main

