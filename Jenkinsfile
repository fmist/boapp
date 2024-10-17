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
             environment {
                DB_DATA = credentials('freemysqlhosting')
             }
             steps {
               sh "USER=sql7738695 PASSWORD=8r2Crcrh9v docker-compose up -d --wait --build"
             }
        }
    }
      post {
          always {
            cleanWs()
          }
      }
}