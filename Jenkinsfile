
pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS')
    }
    triggers {
        cron('0 9 * * *')
    }
    parameters {
        choice(choices: ['regress', 'smoke'], description: 'Выбор сьюта для запуска', name: 'suiteToRun')
    }
    environment {
        mailRecipients = 'dudkomykola@icloud.com'
    }
    tools {
        jdk 'JDK 8u172'
        maven 'Maven 4.0.0'
    }
    stages {
        stage('run tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    withMaven() {
                        sh "mvn clean install -Dgroups=${suiteToRun}"
                    }
                }
            }
        }
        stage('run allure reports') {
            steps {
                allure([includeProperties: true,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: '**/allure-results']]
                ])
            }
        }
    }
    post {
        always {
            echo 'Pipeline is complete'
            emailext (
                subject: "CMXQA.TESTS Отчет прогона тестов [${env.BUILD_NUMBER}] ",
                body: """Подробный allure-отчет: "<a href='${env.BUILD_URL}allure/'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
                to: "${env.mailRecipients}"
            )
        }
    }
}

