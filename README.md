# Monoova-ui test developed with Java-selenium and cucumber

# Overview of scenario

* User registration
* User verifies email
* User login to portal
* User creates automatcher account
* Assertions:
    * User register successfully
    * Email verification
    * User login successfully
    * Validate automatcher account created successfully

# Assumption
* I have developed this project on Mac machine so have not tested it on windows OS. 

# Test execution
* Prerequisite : Please ensure to install following on your machine
      * Java
      * IntelliJ or similar editor
* Checkout this project
* Open the project in IntelliJ or similar editor
* Perform `mvn clean install` from root (monoova-ui-tests) directory
* Perform `mvn test` to execute tests

# Troubleshooting
* if you are using MAC and get chromedriver related error then you need to give permission to access 
ChromeDriver from System Preference >> Security & Privacy >> Allow apps to download and select App store 
and identified developers
* Ensure that you are using chrome driver 86
* if you are using Windows OS, you will need to update `RegisterPage` under `Pages`
line number `102`  to `Keys.CONTROL` from `Keys.COMMAND`
