1. a) Узнать о доступных обновлениях библиотек - mvn versions:display-dependency-updates
        [INFO] The following dependencies in Dependencies have newer versions:
        [INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-6
        [INFO]   org.testng:testng ..................................... 7.1.0 -> 7.3.0
   b) Автоматическое обновление всех версий библиотек - mvn versions:use-latest-versions
        [INFO] Major version changes allowed
        [INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.0.0-alpha-6
        [INFO] Updated org.testng:testng:jar:7.1.0 to version 7.3.0
2. Запуск тестов используя mvn clean test команду и ее вывод
        [INFO] Tests run: 19, Failures: 0, Errors: 0, Skipped: 0
3. Запуск конкретного тестового класса - mvn -Dtest=LoginPageTest test
        [INFO] Running tests.LoginPageTest
        [INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
   Запуск конкретного тестового метода - mvn -Dtest=LoginPageTest#userShouldBeLogined test
        [INFO] Running tests.LoginPageTest
        [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
4. Запуск теста с заданным значением переменной - mvn -Dtest=LoginPageTest#userShouldBeLogined test -Dusername=standard_user
        .login(System.getProperty("username"), PASSWORD)
        [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0