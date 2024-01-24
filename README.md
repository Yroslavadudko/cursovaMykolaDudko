# Individual Project Mykola Dudko

# Project for Testing Kanboard
The project is created for automated testing of project management software – Kanboard.
Technologies and libraries such as testNG, Selenide, Rest Assured, and Allure are used.

## Tools and Libraries
Your project utilizes the following tools and libraries:
- [Kanboard](https://docs.kanboard.org/v1/api/)

## Installation and Running Instructions
1. Clone the repository:

    ```bash
    git clone git@github.com:Yroslavadudko/individualProjectMykolaDudko.git
    ```

2. Ensure that Docker is installed on your machine.
3. Download and save the docker-compose.yml file from [here](https://github.com/robot-dreams-code/QA-Automation-3.0/tree/main/src/main/java/course-work).
4. Execute the following command to start Kanboard using Docker:

    ```bash
    docker-compose up
    ```

   After the launch, find the administrator password in the terminal where you executed the `docker-compose up` command.

## Running the Project Locally
1. Open Kanboard in your web browser.
2. Use the following credentials to log in:
    - Login: admin
    - Password: admin
3. For API tests, use the API key found in Kanboard settings (Settings -> API).
4. Run the automated test:

    ```bash
    mvn clean test
    ```
   To choose which tests you want to execute, edit the configuration file.

## Running the Allure Report

To generate and view Allure reports, use the following commands:

1. **Generate the report:**

    ```bash
    mvn allure:report
    ```

   Generates an HTML report in the `target/site/allure-maven/index.html` directory.

2. **Open the report in the browser:**

    ```bash
    mvn allure:serve
    ```

   Launches a local server and opens the report in the browser.

## Testing Information

- **Kanboard:** [http://localhost/login](http://localhost/login) or [http://127.0.0.1/login](http://127.0.0.1/login)
    - **Login:** admin
    - **Password:** admin
    - **API key for API tests:** Located in settings -> API

- **Jenkins:** [http://localhost:8080](http://localhost:8080) (should redirect to [http://localhost:8080/login?from=%2F](http://localhost:8080/login?from=%2F))
    - **Administrator password:** Found in the terminal where you executed the `docker-compose up` command.




