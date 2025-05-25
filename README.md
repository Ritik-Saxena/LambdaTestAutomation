# 🚀 LambdaTest Automation with Selenium & TestNG

This project runs automated tests on LambdaTest's Selenium Grid using TestNG and Maven.

## 🧰 Tech Stack
- Java
- Maven
- TestNG
- Selenium
- LambdaTest
- Gitpod (for development and execution)

---
## 🔧 Configure your settings and required capabilities before running the test
For running the test script, the username and access key from LambdaTest are required.

Visit the following link to get your credentials: https://www.lambdatest.com/capabilities-generator

## 📝 Update the properties in the code
Now, you have your LambdaTest username and access key. It's time to make changes to the file 'LambdaTest.java'.
```java
String username = <YOUR LT_USERNAME> //Replace with your username
String accessKey = <YOUR LT_ACCESS_KEY> //Replace with your access key
```

## 🧪 To run on LambdaTest
Run the project at the suite level by running testng.xml. This will trigger the parallel runs of LambdaTest.java for **Chrome (v128.0) on Windows 10** and **Edge (v127.0) on MacOS Ventura**.

## 📊 To see the Test Results
Once the test run is successfully completed, visit the following URL to see the results: https://automation.lambdatest.com

* Test run on Microsoft Edge (v127.0) with MacOS Ventura: <br>

![image](https://github.com/user-attachments/assets/b0975503-f9a1-40ed-aa26-850e5617d54f)

* Test run on Chrome (v128.0) with Windows 10: <br>

![image](https://github.com/user-attachments/assets/c521e8af-fbc2-40b9-bfc8-f6a5a237f577)


## 📦 To Run on Gitpod

### 🔗 Step 1: Open the project in Gitpod

Click the button below to launch the project environment:

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/Ritik-Saxena/LambdaTestAutomation)

---

### ▶️ Step 2: Run Tests

Once Gitpod is ready, run the 'parallel' profile mentioned in the pom.xml using the following command in the console:
```bash
mvn test -P parallel
```
<br>

* Finally, the tests ran successfully on GitPod. <br>

![image](https://github.com/user-attachments/assets/d1ee4721-b12a-4bbb-bd15-a435e5bf4c2b)

--- 
If you like this repository, do <img src="https://user-images.githubusercontent.com/62079355/200077014-f3e95bba-57a6-4c7a-b26a-212bf18e5162.png" width=25 height=25> and <img src="https://user-images.githubusercontent.com/62079355/220893415-ea2015e9-6df6-4de2-ab66-041a3f890be2.png" width=25 height=25> the repo for more amazing stuff coming soon.

---
[![GitHub stars](https://img.shields.io/github/stars/Ritik-Saxena/LambdaTestAutomation?style=social)](https://github.com/Ritik-Saxena/LambdaTestAutomation)
[![GitHub followers](https://img.shields.io/github/followers/Ritik-Saxena?style=social)](https://github.com/Ritik-Saxena?tab=followers)
[![GitHub forks](https://img.shields.io/github/forks/Ritik-Saxena/LambdaTestAutomation?style=social)](https://github.com/Ritik-Saxena/LambdaTestAutomation)
[![GitHub watchers](https://img.shields.io/github/watchers/Ritik-Saxena/LambdaTestAutomation?style=social)](https://github.com/Ritik-Saxena/LambdaTestAutomation)


