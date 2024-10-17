pipeline {
   agent any
   environment {
           PATH = "$PATH:/usr/local/bin"
       }
    tools {
        gradle "gradle"
    }

    stages {
        stage('Get project') {
            steps {
                git 'https://github.com/fmist/boapp.git'
            }
        }

        stage('Build') {
            steps {
                sh "gradle clean build -D skipTests"
            }
        }
        stage('Deploy') {
             steps {
               sh "docker-compose up -d --wait --build"
             }
        }
    }
      post {
          always {
            cleanWs()
          }
      }
}