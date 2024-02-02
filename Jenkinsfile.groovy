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
         string(name: 'baseUrl', description: 'Validate Application URL', defaultValue: 'http://localhost')
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
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/ApiTest.xml"
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
