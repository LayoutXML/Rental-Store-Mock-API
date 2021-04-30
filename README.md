# Rental Store Mock API
REST API made with Spring Boot (web, JPA, validation, cache, security), H2 database, Flyway migration, Docker, JUnit and Mockito tests, Lombok. Built on Java 11.

## Use cases
* API users can get a list of available equipment.
* API users can choose a single product and get its details and pricing options.
* API users can delete a product.
* API users can calculate the total price for the chosen product, commitment and rental period.

Each use case corresponds to an endpoint. Technical details and specifications of each can be found in the Documentation.md file.

## Features

* REST API endpoints for each use case mentioned above.
* Spring Boot Validation for these endpoints.
* Error codes for invalid, unauthorized or incorrect data.
* Persistent H2 database.
* Flyway database migrations for setting up and filling database tables.
* Basic Spring Security with a single user.
* Basic Spring Caching for data retrieval and cache eviction upon product deletion.
* Docker script for running the generated JAR file.
* JUnit unit tests for price calculations mentioned below. Mockito for mocking the database for these tests.

## Sample data

| Product | Price/month without commitment| Price/month for 3 month commitment | Price/month for 6 month commitment | Initial charge | Available for rent
|---:|---:|---:|---:|---:|---
|Skis|$35|$30|$25|$35|Yes
|Snowboard|$25|$20|$17|$25|Yes
|Bike|$35|$30|$25|$35|No
|Roller-blades|$17|$13|$10|$17|Yes
|Skateboard|$35|$30|$25|$35|Yes

## Pricing formula

Commitment is a number of months that the customer chooses to rent the equipment for. It can either be 3, 6 months or no commitment. Regardless of commitment, a customer can choose to return the product at a different time in which case they would pay no commitment price.

Pricing formula is as follows:

*total price = initial charge + (return months * price per month, based on commitment)*
 
For example:
* User chooses a skateboard with a commitment of 6 months and chooses to return it after 2 months: 
    * price = $35 initial charge + (2 months * $35 no commitment price) = $105
    

* User chooses roller-blades without a commitment and chooses to return it after 7 months:
    * price = $17 initial charge + (7 months * $17 no commitment price) = $136
