pipeline {
    agent {
        any {
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
        stage('End') {
            steps {
                echo 'All successfully!!!'
            }
        }
    }
}