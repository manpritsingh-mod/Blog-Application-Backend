@Library('shared-library') _
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
                script{
                      println("Code execute till here")
                      mvnBuild()
                }
                // bat 'mvn clean install'
                // script {
                //     def mvnTool = isUnix() ? 'sh' : 'bat'
                //     "${mvnTool}" 'mvn clean install'
                // }
            }
        }

        stage('Run Tests') {
            steps {
                script{
                        mvnTest()
                }
                // bat 'mvn test'
                // script {
                //     def mvnTool = isUnix() ? 'sh' : 'bat'
                //     "${mvnTool}" 'mvn test'
                // }
            }
        }
    }

    post {
        success {
            echo 'Successfully Build!!'
        }
        failure {
            echo 'Build Failed !!'
        }
    }
}
