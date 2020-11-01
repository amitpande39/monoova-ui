# Monoova-ui test developed with Java-selenium and cucumber

# Overview of scenario

* User registration
* User verifies email
* User login to portal
* User creates an automatcher account
* Assertions:
    * User registration successfully
    * Email verification successfully
    * User login to monoova portal successfully
    * Validate automatcher account is created successfully

# Assumption
* I have developed this project on Mac machine so have not tested it on windows OS. 

# Test execution
* Prerequisite : Please ensure to install following on your machine
    * Java
    * IntelliJ or similar editor

* Unzip this project
* Open the project in IntelliJ or similar editor
* Perform `mvn clean install` from root (monoova-ui-tests) directory
* Perform `mvn test` to execute tests

# Troubleshooting
* if you are using MAC and get chromedriver related error then you need to give permission to access 
ChromeDriver from System Preference >> Security & Privacy >> Allow apps to download and select App store 
and identified developers
* Ensure that your chrome driver matches the chrome browser version
* if you are using Windows OS, you will need to update `RegisterPage` under `Pages`
line number `102`  to `Keys.CONTROL` from `Keys.COMMAND`
