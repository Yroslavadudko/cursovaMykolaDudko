pipeline {
    agent any
    triggers {
            cron('0 9 * * *')
        }
    stages {
        stage('Build') {
            steps {
                // Команди для збирання вашого проекту
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                // Команди для запуску тестів
                sh 'mvn clean test'
            }
        }
        stage('Deploy') {
            steps {
                // Команди для розгортання вашого проекту
                // Наприклад, можливо ви залишите цей етап порожнім, якщо розгортання автоматично відбувається після успішного тестування
            }
        }
    }
}

