# Individual Project Mykola Dudko

# Проект для тестування Kanboard
Проект створений для автоматизованого тестування програмного забезпечення для управління проектами – Kanboard.
Використовуються технології та бібліотеки, такі як testNG, Selenide, Rest Assured, Allure.

## Інструменти та Бібліотеки
Ваш проект використовує такі інструменти та бібліотеки:
- [Kanboard](https://docs.kanboard.org/v1/api/)

## Інструкції з встановлення та запуску
1. Клонуйте репозиторій:

    ```bash
    git clone git@github.com:Yroslavadudko/individualProjectMykolaDudko.git
    ```

2. Переконайтеся, що Docker встановлений на вашому пристрої.
3. Завантажте та збережіть docker-compose.yml файл з [силання](https://github.com/robot-dreams-code/QA-Automation-3.0/tree/main/src/main/java/course-work).
4. Виконайте команду для підняття Kanboard за допомогою Docker::

    ```bash
    docker-compose up
    ```

   Після запуску, знайдіть пароль адміністратора у терміналі, де ви виконали команду `docker-compose up`.

## Запуск проекту локально
1. Відкрийте Kanboard у вашому веб-браузері.
2. Використовуйте наступні облікові дані для входу:
* Логін: admin
* Пароль: admin
3. Для API тестів використовуйте ключ API, який можна знайти в налаштуваннях Kanboard (Settings -> API).
4. Запустьть автотест:

    ```bash
    mvn clean test
    ```
    Для того, щоб обрати, які тести ви хочете виконати, редагуйте конфігураційний файл.
## Запуск Allure звіту

Для генерації та перегляду звітів Allure, використовуйте наступні команди:

1. **Генерація звіту:**

    ```bash
    mvn allure:report
    ```

   Згенерує HTML звіт у директорії `target/site/allure-maven/index.html`.

2. **Відкриття звіту у браузері:**

    ```bash
    mvn allure:serve
    ```

   Запустить локальний сервер та відкриє звіт у браузері.

## Інформація для тестування

- **Kanboard:** [http://localhost/login](http://localhost/login) або [http://127.0.0.1/login](http://127.0.0.1/login)
    - **Логін:** admin
    - **Пароль:** admin
    - **API ключ для API тестів:** Знаходиться в налаштуваннях -> API

- **Jenkins:** [http://localhost:8080](http://localhost:8080) (повинно перенаправити на [http://localhost:8080/login?from=%2F](http://localhost:8080/login?from=%2F))
    - **Пароль адміністратора:** Знаходиться в терміналі, де ви виконали команду `docker-compose up`.



