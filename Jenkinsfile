pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {
        stage('Clone Repo') {
            steps {
                git 'https://github.com/manpritsingh-mod/Blog-Application-Backend.git'
            }
        }

        stage('Build with Maven') {
            steps {
                script {
                    def mvnTool = isUnix() ? 'sh' : 'bat'
                    "${mvnTool}" 'mvn clean install'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    def mvnTool = isUnix() ? 'sh' : 'bat'
                    "${mvnTool}" 'mvn test'
                }
            }
        }
    }

    post {
        success {
            echo 'Build & Tests Passed!'
        }
        failure {
            echo 'Build or Tests Failed.'
        }
    }
}
