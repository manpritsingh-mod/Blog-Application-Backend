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
                bat 'mvn clean install'
                // script {
                //     def mvnTool = isUnix() ? 'sh' : 'bat'
                //     "${mvnTool}" 'mvn clean install'
                // }
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
                // script {
                //     def mvnTool = isUnix() ? 'sh' : 'bat'
                //     "${mvnTool}" 'mvn test'
                // }
            }
        }
    }

    post {
        success {
            emailext(
                subject: 'Build Successful: ${JOB_NAME} #${BUILD_NUMBER}',
                body: 'Good job! Build passed.',
                to: 'smanprit022@gmail.com'
            )
        }
        failure {
            emailext(
                subject: 'Build Failed: ${JOB_NAME} #${BUILD_NUMBER}',
                body: 'Oops! Build failed. Please check Jenkins.',
                to: 'smanprit022@gmail.com'
            )
        }
    }
}
