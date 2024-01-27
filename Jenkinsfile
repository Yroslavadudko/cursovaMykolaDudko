pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS')
    }
    triggers {
        cron('0 9 * * *')
    }
    parameters {
        choice(choices: ['regress', 'smoke'], description: 'MyTestSuite', name: 'MyTestSuite')
    }
    environment {
        mailRecipients = 'dudkomykola@icloud.com'
    }
    tools {
         jdk 'JDK 9.0.4'
         maven 'Maven 3.9.6'
    }
    stages {
        stage('Run Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    withMaven() {
                        sh "mvn clean install -Dgroups=${MyTestSuite}"
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


