# Property Source Issue

## Prerequisites
1. Create a file external to the project with the following:
    ```
   spring.profiles.active=disconnected,local
    ```
2. Adjust the `TestConfig` property source to match the location of the file:
   ```
   @PropertySource(value = "file:/c:\\demo\\test.properties")
   ```
   
## Testing
1. Run with Spring Boot Version `2.4.5` (the default)

   This will display in the console.log `Should be visible`. It will not display anything from `two()` as expected since that is guarded by
the `@Profile(!local)` annotation and local is one of the active profiles

2. Within `build.gradle` comment out spring boot version `2.4.5`
3. Within `build.gradle` uncomment out spring boot version `2.5.4

   This will display logs from both `TestConfig#one()` and `TestConfig#two()` despite local still being an active profile.
   In addition, the console.log will also print out the `env.getActiveProfiles` array which shows as empty