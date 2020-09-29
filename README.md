# UpgradeAssignment
UpgradeAssignment

General Information about the project and environment.

1. Provided Solution is for the Web and API Scenario.
2. Java 8 is used as programming language.
3. Maven is used for the dependency management.
4. Selenium chrome webdriver is used for automating the web application.
5. No need to download any external chrome webdriver it is handled by maven dependency "webdrivermanager".
7. Intellij is used as an IDE
8. TestNG is used as test managmnent tool.
9. RestAssured is used for automating API scenarios.


How to use this Project.

1. Open Intellij and Navigate to File -> New ->  Project From Version Control
2. Select Repository URL
3. Paste this link in URL "https://github.com/tarunjandra/UpgradeAssignment.git"
4. Provide path to the local folder to create local repository
5. Press clone button
6. Select Open project in New Window
7. Click on Project Folder on left hand side top corner.
8. From top bar select File -> Project Structure -> Modules 
9. Expand src -> main -> CLICK ON "Testing" folder
10. Now click on Sources button next to "Mark as"
11. Press Apply and OK

Now Project is ready to be used.

Executing Test.

Project is Structure as follow:
1. All test scripts can be grouped under tests package.
2. Any data required for the testing like URLs, key value pair, User Profiles are mainatined under Data package.
3. BrowserHelper class under browserHelper package contains all the methods which can be reused again and again accros the page objects and scripts.
4. Each page has a seprate pageObject class and pageFactory class, which can help in scalability and mainatainability of the code.
5. For API testing two sprate classes are created for handling the request and response.
6. Data is stored in Java Collections for now, but can be easily stored in external file, database using DAO.

Feel free to reach out to me at jandra.tarun1905@gmail.com if have any queries

Thanks 

Tarun Kumar

