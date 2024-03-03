pipeline {
    agent {
        any {
            args '-v /jenkins/.gradle:/jenkins/.gradle'
            image 'gradle:latest'
        }

    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew :build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew :test'
            }
        }
    }
}