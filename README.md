# Profile Manager

A simple profile manager app. This app has a login screen and when user login for the first time app access mysql to find user and cache it. From there the user is cached to improve app perfomance. If login is success the user is redirect to home screen, if not user is redirect to "oops" screen.

## Tech stack

   * [Docker](https://www.docker.com/)
   * [Docker Compose](https://docs.docker.com/compose/)
   * [Spring Boot](https://projects.spring.io/spring-boot/)
   * [Redis](https://redis.io/) (as cache database)
   * [MySQL](https://www.mysql.com/) (as relational database)
   * [Twitter Bootstrap](http://getbootstrap.com/)
   
## How to run the application

   * Into root directory run `. run.sh`. This will build a Docker image and after that, will run `docker-compose up` automatically.
   * For the first time it is possible that the app does not run because MySQL take more time than app to be ready, in this case, just `Ctrl+C` and run again `. run.sh`.
   