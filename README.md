## book-your-movie
online movie ticket booking system on spring boot and REST api

## To run
1. import project in intellij
2. import the dependencies.
3. Start the spring-boot application
4. All DDL and Insert queries will be executed while startup of the application. So, some test data will be there in inmemory H2 DB
5. After successfull startup of the application.


## GET: http://localhost:8888/book-your-show/api/v1/city/INDORE
List down all the theatres in INDORE city with full information of screens and movie shows on those screens.
Try with other city JABALPUR/BHOPAL 

## GET: http://localhost:8888/book-your-show/api/v1/movie/Harry Potter 1
movie name could be any word matching to movie. like 
- 'Harry' would result to 'Harry Potter 1'
- 'Har' would result to 'Harry Potter 1'
- 'Harry  Potter 2' would result to 'Harry Potter 2'

below url can be tried
- GET: http://localhost:8888/book-your-show/api/v1/movie/Spider Man
- GET: http://localhost:8888/book-your-show/api/v1/movie/Pushpa

## POST: http://localhost:8888/book-your-show/api/v1/book
- To Book a movie ticket hit the above url with below details in request body
    - {
          "city":"INDORE",
          "movieName":"Harry Potter 1",
          "showId":"1",
          "theatreId":"1",
          "noOfSeat":"10",
          "userVO":{
            "username":"ajaykanojiya",
            "contactNo":"987654321",
            "email":"ajaykanojiya@gmail.com"
       }
}

- If user book seat more than or equal to 'user.discount.seat' then 'user.discount.rate'
percentage discount will be given on total amount. Both fields are configured in 
application.properties file
    - user.discount.seat=3
    - user.discount.rate=10 

- Price for a seat can also be configured through properties file
    - theatre.show.priceperseat=3
      






