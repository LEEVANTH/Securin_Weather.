Weather REST API – Spring Boot
Base URL
http://localhost:8080/weather
API Endpoints
Get All Weather Data

Endpoint

GET /weather

Description
Returns all weather records stored in the database.

Example

http://localhost:8080/weather
Get Sorted Weather Data

Endpoint

GET /weather?sortBy={field}&direction={asc|desc}

Query Parameters

Parameter	Required	Description
sortBy	No	Field name (temperature, city, condition)
direction	No	Sort order: asc or desc (default: asc)

Examples

/weather?sortBy=temperature
/weather?sortBy=city&direction=desc
Get Weather by Condition

Endpoint

GET /weather/condition?conds={condition}

Description
Returns weather records matching the given condition.

Example

/weather/condition?conds=Sunny
Get Weather Above a Temperature

Endpoint

GET /weather/temp?temp={value}

Description
Fetches weather records where temperature is greater than the specified value.

 
