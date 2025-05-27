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
                // bat 'mvn clean install'
                // script {
                //     def mvnTool = isUnix() ? 'sh' : 'bat'
                //     "${mvnTool}" 'mvn clean install'
                // }
                mvnBuild()
            }
        }

        stage('Run Tests') {
            steps {
                // bat 'mvn test'
                // script {
                //     def mvnTool = isUnix() ? 'sh' : 'bat'
                //     "${mvnTool}" 'mvn test'
                // }
                mvnTest()
            }
        }
    }

    post {
        success {
            // echo 'Successfully Build!!'
             slackSend (
                channel: '@jenkins',
                color: 'good',
                message: "*SUCCESS*: Job completed successfully."
            )
        }
        failure {
            // echo 'Build Failed !!'
            slackSend(
                channel: '@jenkins'
                color: 'bad',
                message: "*FAILURE* Job Failed"
            )
        }
    }
}
