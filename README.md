# Spring Cloud Projects Configuration

Uses Zuul, Eureka, Ouath2 Security with two resources APIs (query and otp), and an authentication provider.

Check:

 - POST http://localhost:9500/authentication-provider/authenticate
 - POST http://localhost:9500/oauth-server/oauth/token
 - GET http://localhost:9500/oauth-server/user
 - GET http://localhost:9500/query-api/credit-cards
 - POST http://localhost:9500/otp-api/otp
