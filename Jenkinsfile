pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS')
    }
    parameters {
        string(name: 'MyTestSuite', description: 'Enter the name of the Test Suite', defaultValue: 'ApiProjectsTests')
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
        stage('Run Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    withMaven() {
                        sh "mvn clean test"
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
