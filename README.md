# Weather API  

## The Brief

Develop a Weather API to;

* Get the weather for an inputted location
* Create the logic to determine how the user should prepare for a day outside (i.e. clothes/sunscreen/umbrella/coat etc) 



## Project Criteria

* Create API endpoints with the appropriate HTTP verbs
* Ensure API base URL and endpoints are appropriately named
* Include the addition of unit tests
* Include README to document the ky features of your solution, your assumptions approaches and future thoughts
* API endpoints must be well documented
* Apply error and exception handling considerations in your API design
* Include an /info endpoint to give the user information on how the application works and a /health endpoint to give the health of the application(using the Java Actuator dependency)  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Weather API

## Approach

###  Phase 1
The team initially came together and adopted the [MoSCoW](https://www.productplan.com/glossary/moscow-prioritization/) Framework to help define the scope of the project and Minimum Viable Product (MVP).

* MUST Have (MVP);
  * Weather API that allows a client to request the current weather for their location.  
    Weather API returns a JSON response detailing the current weather.
  * Java Spring Boot backend that will consume the public API
  * Postman as the client to test the GET requests
  * Spring boot Java Actuator dependency for including the /info and /health endpoints
  
* SHOULD Have;
  * Deploy API onto a cloud service such as AWS or Heroku
  * API Documentation, in accordance with the OpenAPI specification, using  Swagger 3

* COULD Have;
* Web based client interface
  * Use a Twilio API to send a text to the user 

* WILL NOT Have - Not identified at this stage
  
### Phase 2

* Trello Scrum board was set up to manage the project using the [Agile](https://www.atlassian.com/agile) Methodology
* Stand-ups at 10am each day
* The Sprints for each Scrum were between 1 and 2 days
* Mobbing to;
  * initially set up the Spring Boot MVC framework and code for the project
  * define the endpoints
  * for code reviews.
* Assignment of tickets to individual team members
  
* The initial API that we were going to use was too complex for our requirements and would have involved multiple GET requests to drill down and obtain the relevant data. Hence, we collaborated as a group to identify the [OpenWeatherMap API](https://openweathermap.org/api) as more suitable.

### Phase 3

1. Implemented OpenWeatherMap API to be directly consumed within the MVC framework
2. Tested endpoint using Postman
3. Implemented Swagger 3 to document the Weather API
4. Implemented the Spring Boot Java Actuator Dependency to include the /info and /health endpoints
5. Fully functional MVP achieved
6. Unit testing 
7. Code Freeze

### Phase 4 - Final 

* Deployed the Weather API onto the Heroku Cloud Service
* Weather API ready for demo

## Conclusions
 
The purpose of this project was to utilise the Agile Methodology to manage the development lifecycle of the Weather API.
This was achieved in a very supportive and collaborative way by the whole team working cohesively together to promote the "Agile" dynamic.
Essentially, there were two learning curves; the development of a RestAPI and utilising the Agile Methodology to facilitate this. 
Hence, the success of this project is demonstrated by the final application. 