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
            // echo 'Successfully Build!!'
             slackSend (
                channel: '@Jenkins',
                color: 'good',
                message: "*SUCCESS*: Job completed successfully."
            )
        }
        failure {
            // echo 'Build Failed !!'
            slackSend(
                channel: '@Jenkins'
                color: 'bad',
                message: "*FAILURE* Job Failed"
            )
        }
    }
}
