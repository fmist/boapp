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
//         stage('SonarQube Analysis') {
//             steps {
//               sh "gradle sonar"
//             }
//         }
//         stage('Deploy') {
//              steps {
//                sh "docker-compose up -d --wait --build"
//              }
//         }
        stage("Run") {
            steps {
                sh "java -jar build/libs/bo-0.0.1-SNAPSHOT.jar"
            }
        }
    }
      post {
          always {
            cleanWs()
          }
      }
}