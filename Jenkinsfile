pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS')
    }
    parameters {
        string(name: 'MyRegressionSuite', description: 'Enter the name of the Test Suite', defaultValue: 'MyTestSuite')
    }
    environment {
        mailRecipients = 'dudkomykola@icloud.com'
        JAVA_HOME = '/usr/bin/java'
        M2_HOME = '/usr/local/Cellar/maven/3.9.6/libexec'
    }
    tools {
        jdk 'JDK 17'
        maven 'Maven'
    }
    stages {
        stage('Build the Project') {
            steps {
                // Крок для збірки проекту
                sh "mvn clean install -DskipTests"
            }
        }
        stage('Run Tests') {
            steps {
                // Крок для запуску контейнера Docker зі сторінкою Kanboard
                script {
                    docker.image('kanboard/kanboard:latest').withRun('-p 80:80') { c ->
                        // Команди для запуску тестів на вашій сторінці Kanboard
                        sh "mvn clean test -DMyRegressionSuite=${MyRegressionSuite}"
                    }
                }
            }
        }
        stage('Publish Allure Report') {
            steps {
                // Крок для публікації звіту Allure
                allure([includeProperties: false,
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
    post {
        always {
            echo 'Pipeline is complete'
            // Крок для відправки електронного листа зі звітом
            emailext (
                subject: "CMXQA.TESTS Test Run Report [${env.BUILD_NUMBER}] ",
                body: """Detailed allure report: "<a href='${env.BUILD_URL}allure/'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
                to: "${env.mailRecipients}"
            )
        }
    }
}

