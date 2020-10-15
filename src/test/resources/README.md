1. a) Узнать о доступных обновлениях библиотек - mvn versions:display-dependency-updates
   b) Автоматическое обновление всех версий библиотек - mvn versions:use-latest-versions
2.
3. Запуск конкретного тестового класса - mvn -Dtest=ShoppingCartTest test
   Запуск конкретного тестового метода - mvn -Dtest=TestCircle#userShouldBeLogined test
4. Запуск теста с заданным значением переменной - mvn test -Dusername=standard_user