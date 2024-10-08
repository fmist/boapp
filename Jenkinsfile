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
         stage('SCM') {
            checkout scm
          }
          stage('SonarQube Analysis') {
            withSonarQubeEnv() {
              sh "./gradlew sonar"
            }
          }
        stage('Deploy') {
             environment {
                DB_DATA = credentials('mysql')
             }
             steps {
               sh "USER=user PASSWORD=123 docker-compose up -d --wait --build"
             }
        }
    }
      post {
          always {
            cleanWs()
          }
      }
}