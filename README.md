# Automation tests' examples for the "Brainscape" platform

![](https://theme.zdassets.com/theme_assets/2092825/5f93252045a23abd2bb2929b16bb400d58ed0787.png)
> <a target="_blank" href="https://www.brainscape.com/">Website link</a>

## Table of contents
+ [Description](#Description)
+ [Tools](#Tools)
+ [List of checks](#list-of-checks)
+ [How to run autotests remotely](#how-to-run-autotests-remotely)
+ [How to run autotests locally](#how-to-run-autotests-locally)
+ [Test reports](#test-reports)
+ [Attachments](#Attachments)
+ [TMS integrations](#tms-integrations)
+ [Notifications](#Notifications)

## <a name="Description">Description</a>
This test project was done as a part of the homework of The QA Automation School <a href="https://qa.guru/">QA.GURU</a>. 

## <a name="Tools">Tools</a>

| ![Java](/readMeContent/logos/Java.png) | ![Gradle](/readMeContent/logos/Gradle.png) | ![JUnit5](/readMeContent/logos/JUnit5.png) | ![Selenide](/readMeContent/logos/Selenide.png) | ![Jenkins](/readMeContent/logos/Jenkins.png) | ![Allure_Report](/readMeContent/logos/Allure_Report.png) | ![AllureTestOps](/readMeContent/logos//AllureTestOps.png) | ![Telegram](/readMeContent/logos/Telegram.png) |
| ------ | ------ | ------ | ------ | ------ | ------------ | ------------ | ------ |
| Java | Gradle | JUnit5 | Selenide | Jenkins | Allure Report | Allure TestOps | Telegram |

## <a name="ListOfChecks">List of checks</a>

**Login form**
- [x] Check the visibility of the login form
- [x] Check successful login via email
- [x] Check login failed due to an incorrect email
- [x] Check login failed due to an incorrect password

**Registration form**
- [x] Check the visibility of the registration form
- [x] Check successful registration (_part of the test is disabled to avoid the creation of new test accounts_)
- [x] Check registration failed due to an existing email

**Commercial video on the Landing page**
- [x] Check the visibility of the modal form with the video + check that the video is playable

## <a name="how-to-run-autotests-remotely">How to run autotests remotely</a>
Automation tests can be run with the **Jenkins**' job: <a href="https://jenkins.autotests.cloud/job/016-Nusae-java_hw_14/build">_here's the link_</a>.

To start a new run, click the button **Build with Parameters**.
![Screen of Jenkins build](/readMeContent/images/Build%20with%20parameters.png)

After that you can choose a few parameters.

- **Available browsers**: Chrome
- **Available browser's versions**: 100.0, 99.0
- **Available browser's size**: 1920x1080, 1366x768, 1024x768

And then you need to click the **Build** button.
![Screen of Jenkins build 2](/readMeContent/images/Build.png)

## <a name="how-to-run-autotests-locally">How to run autotests locally</a>
Here's the command to start a new run locally:

```bash
./gradlew clean test -Denv=local -DtestUserEmail="your_user_email" -DtestUserPassword="your_user_password" -DtestUserNameAndSurname="your_user_name_and_surname"
```
:exclamation: Please note that the test user's credentials that are used in the remote run are hidden and not available in the local run, so you'd need to replace this data (e.g., you could create your test user and use its creds).

## <a name="test-reports">Test reports</a>
**For remote runs**:
A test report will be automatically generated after an autotests run's completion. You can check an **Allure report** in the **Jenkins** interface:
![Screen where to find Allure report](/readMeContent/images/Allure.png)
![Screen with Allure report](/readMeContent/images/Allure%20Report.png)

**For local runs**:
Run the task "allureServe"
![Screen allureServe](/readMeContent/images/allureServe.png)

## <a name="Attachments">Attachments</a>
Each test result in **Allure reports** includes attachments, such as screenshot, page source, video, and browser console logs.
![Screen of attaches](/readMeContent/images/Attachments.png)

Example of the video with record of the test execution:
![Gif of video](/readMeContent/images/Video%20from%20test%20run.gif)

## <a name="TMS">TMS integrations</a>
Test run results will also be available in the test management system **Allure TestOps**.
![Screen where to find Allure TetsOps](/readMeContent/images/Allure%20TestOps.png)
![Screen with testcases in Allure TetsOps](/readMeContent/images/Allure%20TestOps%20Report.png)

## <a name="Notifications">Notifications</a>
The **telegram bot** will send a message to the **telegram group** about the completion of a test run. The text of the bot's message includes a link to the **Allure test report** in the **Jenkins**.

![Telegram message](/readMeContent/images/Telegram%20message.png)
