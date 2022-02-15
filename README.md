# QAConsultant Assignment

General Information about the project and environment.

1. Provided Solution is for the Web Data Tables.
2. Java 8 is used as programming language.
3. Maven is used for the dependency management.
4. Selenium chrome webdriver is used for automating the web application.
5. No need to download any external chrome webdriver it is handled by maven dependency "webdrivermanager".
6. Intellij is used as an IDE
7. TestNG is used as test management tool.
8. Result files are stored in test-output --> Default Suits folder.

How to use this Project.

1. Open Intellij and Navigate to File -> New ->  Project From Version Control
2. Select Repository URL
3. Paste this link in URL "https://github.com/tarunjandra/UpgradeAssignment.git"
4. Provide path to the local folder to create local repository
5. Press clone button
6. Select Open projects in New Window
7. Click on Project Folder on left hand side top corner.
8. From top bar select File -> Project Structure -> Modules 
9. Expand src -> main -> CLICK ON "Testing" folder
10. Now click on Sources button next to "Mark as"
11. Press Apply and OK

Now Project is ready to be used.

Executing Test.

Project is Structure as follows:
1. All test scripts can be grouped under tests package.
2. All unit test scripts can be grouped under unitTest package.
3. Any data required for the testing like URLs, key value pair, User Profiles are maintained under Data package.
4. BrowserHelper class under browserHelper package contains all the methods which can be reused again and again across the page objects and scripts.
5. In future if there are more web pages they should have separate pageObject class and pageLocators class, which can help in scalability and maintainability of the code.

Feel free to reach out to me at jandra.tarun1905@gmail.com if you have any queries

Thanks and Regards

Tarun Kumar

