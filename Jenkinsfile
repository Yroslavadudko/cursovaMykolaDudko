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
        docker 'Docker'
    }
    stages {
        stage('Build the Project') {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }
        stage('Run Tests') {
            steps {
                // Крок для запуску контейнера Docker зі сторінкою Kanboard
                script {
                    docker.image('kanboard/kanboard:latest').withRun('-p 80:80') { c ->
                        sh "mvn clean test -DbaseUrl=${baseUrl}"
                    }
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

