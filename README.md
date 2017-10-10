```
 +-+ +-+ +-+ +-+ +-+ +-+ +-+   +-+ +-+   +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 |W| |e| |l| |c| |o| |m| |e|   |T| |o|   |D| |e| |v| |e| |r| |z| |o| |n| |e| |!| |!|
 +-+ +-+ +-+ +-+ +-+ +-+ +-+   +-+ +-+   +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
```


### File Structure
```
deverzone/
 ├──src/                                                        * our source files
 │   ├──main
 │   │   ├──java.com.deverzone
 │   │   │   ├──config
 │   │   │   │   └──WebSecurityConfig.java                      * config file for filter, custom userSerivce etc.
 │   │   │   ├──model
 │   │   │   │   ├──user
 │   │   │   │   │   ├──Authority.java
 │   │   │   │   │   ├──CustomUserDetail.java                   * custom UserDetail implemtation
 │   │   │   │   │   ├──UserTokenState.java                     * JWT model
 │   │   │   │   │   └──User.java                               * our main user model.
 │   │   │   │   └──support
 │   │   │   │       ├──Comment.java                            * surpport comment model.
 │   │   │   │       ├──FAQ.java                                * surpport FAQ model.
 │   │   │   │       ├──Notice.java                             * surpport Notice model.
 │   │   │   │       └──QnA.java                                * surpport QnA model.
 │   │   │   ├──repository                                      * repositories folder for accessing database
 │   │   │   │   ├──RoleRepository                              * role repository
 │   │   │   │   ├──UserRepository.java                         * user reposiroty
 │   │   │   │   ├──CommentRepository.java                      * comment reposiroty
 │   │   │   │   ├──FAQRepository.java                          * FAQ reposiroty
 │   │   │   │   ├──QnARepository.java                          * QnA reposiroty
 │   │   │   │   └──NoticeRepository.java                       * Notice reposiroty
 │   │   │   ├──rest                                            * rest endpoint folder
 │   │   │   │   ├──AuthenticationController.java               * auth related REST controller, refresh token endpoint etc.
 │   │   │   │   └──UserController.java                         * REST controller to handle User related requests
 │   │   │   ├──security                                        * Security related folder(JWT, filters)
 │   │   │   │   ├──auth
 │   │   │   │   │   ├──AuthenticationFailureHandler.java       * login fail handler, configrued in WebSecurityConfig
 │   │   │   │   │   ├──AuthenticationSuccessHandler.java       * login success handler, configrued in WebSecurityConfig
 │   │   │   │   │   ├──AnonAuthentication.java                 * It creates Anonymous user authentication object. If the user doesn't have a token, we mark the user as an anonymous visitor.
 │   │   │   │   │   ├──LogoutSuccess.java                      * controls the behavior after sign out.
 │   │   │   │   │   ├──RestAuthenticationEntryPoint.java       * handle auth exceptions, like invalid token etc.
 │   │   │   │   │   ├──TokenAuthenticationFilter.java          * the JWT token filter, configured in WebSecurityConfig
 │   │   │   │   │   └──TokenBasedAuthentication.java           * this is our custom Authentication class and it extends AbstractAuthenticationToken.
 │   │   │   │   └──TokenHelper.java                            * token helper class
 │   │   │   ├──service
 │   │   │   │   ├──user
 │   │   │   │   │   ├──UserService.java                        * userService interface
 │   │   │   │   │   ├──CustomUserDetailsService.java           * custom UserDatilsService implementataion, tells formLogin() where to check username/password
 │   │   │   │   │   └──UserServiceImpl.java
 │   │   │   │   └──support
 │   │   │   │       ├──CommentService.java                     * CommentService class
 │   │   │   │       ├──FAQService.java                         * userService class
 │   │   │   │       ├──NoticeService.java                      * NoticeService class
 │   │   │   │       └──QnAServiceImpl.java                     * QnAService class
 │   │   │   └──Application.java                                * Application main enterance
 │   │   └──recources
 │   │       ├──static                                          * static assets are served here(Angular and html templates)
 │   │       └──application.properties                          * application variables are configured here
 │   └──test                                                    * Junit test folder
 └──pom.xml                                                     * what maven uses to manage it's dependencies
```

### Configuration
- **WebSecurityConfig.java**: The server-side authentication configurations.
- **application.yml or application.properties**: Application level properties i.e the token expire time, token secret etc. You can find a reference of all application properties [here](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html).
- **JWT token TTL**: JWT Tokens are configured to expire after 10 minutes, you can get a new token by signing in again.
- **Using a different database**: This Starter kit is using an mysql database that is automatically configured by Spring Boot. If you want to connect to another database you have to specify the connection in the *application.properties* in the resource directory.

