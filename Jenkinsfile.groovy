pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS')
    }
    triggers {
        cron('0 9 * * *')
    }
    parameters {
         string(name: 'MyRegressionSuite', description: 'Enter the name of the Test Suite', defaultValue: 'MyTestSuite')
         string(name: 'baseUrl', description: 'Validate Application URL', defaultValue: 'http://localhost:80/wd/hub')
    }
    environment {
        mailRecipients = 'dudkomykola@icloud.com'
    }
    tools {
        jdk 'JDK'
        maven 'Maven'
    }
    stages {
        stage("Build the Project") {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }
        stage("Run Tests") {
            steps {
                script {
                    // Запуск тестів з базовим URL, який передається як параметр
                    sh "mvn clean test -DbaseUrl=${baseUrl}"
                }
            }
        }
        stage("Publish Allure Report") {
            steps {
                allure([includeProperties: false,
                        jdk:'',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
