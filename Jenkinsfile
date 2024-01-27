pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS')
    }
    parameters {
        choice(choices: ['ApiProjectsTests', 'TestLoginUi', 'TestCreateProjectUi'], description: 'Select Test Suite', name: 'MyTestSuite')
    }
    environment {
        mailRecipients = 'dudkomykola@icloud.com'
    }
    tools {
        jdk 'java-17-openjdk'
        maven 'Maven'
    }
    stages {
        stage('Run Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    withMaven() {
                        sh "mvn clean test -Dtest=${params.MyTestSuite}"
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
    post {
        always {
            echo 'Pipeline is complete'
            emailext (
                subject: "CMXQA.TESTS Test Run Report [${env.BUILD_NUMBER}] ",
                body: """Detailed allure report: "<a href='${env.BUILD_URL}allure/'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
                to: "${env.mailRecipients}"
            )
        }
    }
}
