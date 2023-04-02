This repo is used to maintain the assignment

Background:


**Acceptance criteria**

  1. Verification of "Carbon credits" value in "Name" property
  
  2. Verification of boolean value as 'true' in "CanRelist" property
  
  3. To verify that the Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"

**Built with**

Java, RestAssured Maven,TestNG,Intellij

**Prerequisites**

Since test scripts are created in apache maven project, so maven should be installed and configured in local system on which the tests are going to be executed.

TestNG framework should be configured in Intellij

**Script Execution:**

Approach 1- By Maven test command as follow

mvn test

OR

Navigate to src/test/resources/testng.xml, right click on it and choose "Run"

**Script Architecture**

src/main/java/com/assignment/BaseClass - A parent base class to set up properties file and fetching and inititating URI value from properties file to be inherited by other child classes.

src/main/java/com/assignment/Utilities- A utility class consists of getter and setter methods to set and get properties file.

src/test/java/com/assignment/RestTest - Contains a script to validate the acceptance criteria

src/test/java/resouces/ - contains testng.xml to configure test case execution enviornment

src/test/resources/properties/config.properties- property file related with configuration for test enviornment.For instance, the URI for AUT.

Author

Hitesh Ghai
