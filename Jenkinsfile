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
         string(name: 'baseUrl', defaultValue: 'http://127.0.0.1/login', description: 'Validate Application URL')
    }
    environment {
        mailRecipients = 'dudkomykola@icloud.com'
    }
    tools {
        jdk 'JDK'
        maven 'Maven'
    }
    stages {
        stage('Build the Project') {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }
        stage('Start Kanboard Container') {
            steps {
                script {
                    // Запуск контейнера з канбордом
                    docker.image('kanboard/kanboard:latest').run('-p 80:80')
                }
            }
        }
        stage('Run Tests') {
            steps {
                script {
                    // Запуск тестів з базовим URL, який передається як параметр
                    sh "mvn clean test -DbaseUrl=${baseUrl}"
                }
            }
        }
        stage('Stop Kanboard Container') {
            steps {
                script {
                    // Зупинка контейнера з канбордом після закінчення тестів
                    docker.image('kanboard/kanboard:latest').stop()
                }
            }
        }
        stage('Publish Allure Report') {
            steps {
                allure([includeProperties: false,
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
