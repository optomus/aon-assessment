## Author
> Dash Nava

# Opinion Tasks
---
## Trends
Describe a trend which has happened with enterprise applications over the last two or three years. 
How do you see this trend influencing corporate application development? What are you doing to prepare for this trend?


Answer) The enterprise applications are moving towards micro services, cloud base solutions and frontend UI frameworks.
These trends influence in terms of development effort, license cost, support cost

## Describe Software that Delivers User Value
Describe a product or project you worked on that delivered high value to the user. 
Which specific aspects did you think were critical in successfully creating value for the user?

Answer) The project that I worked let the customer to mix and match the insurance products as a package along with the finance repayments.
As a customer I was able to understand the repayment amount changes by adding and removing products on the fly which assisted to plan my financials.

Seamless UI, better UX, easy to understand wordings

## Your Values
What are your core values / principals as a software engineering professional working in a team environment and why are they important to you?

Answer)

# Programming Task
---
# Solution Overview

The solution is build as a multi module maven spring boot project. 
The project is broken down into sub logical modules.


## Technologies
* Java 8
* Spring Boot
* Swagger

## Build Dependencies

* Apache Maven (Min 3)
* Oracle JDK (Min 1.8)

## Modules

### 1. iplatform-domain
---
This module has the domain and common models, repositories, specifications.
### 2. iplatform-service
---
This module has the domain and business.

### 3. API
---
This module exposes the REST API endpoints. The API contract can be viewed at ```http://localhost:9091/swagger-ui.html```

## How to run the application


### Run from IDE
Double click the ```spring-boot:run``` goal from the editor.

![IDE Screenshot](docs/AON.JPG)

### Run using maven
Run the following command `mvn spring-boot:run` soon after moving to API module from the terminal/command prompt.
<br>```e.g. c:\project\aon-assessment\iplatform-api>mvn spring-boot:run```

#### Test Data for API
```json
{
  "annualTurnover": 600000,
  "occupation": "Plumber",
  "postcode": "2000"
}
```


