pipeline {
    agent any

tools {
        //jdk 'jdk8'
        maven 'jetty-app-maven'
    }
    stages {

    /*stage('SCM') {
      git 'https://github.com/SingleDreamer/jetty-app.git'
      }*/
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
	stage('Sonar') {
            steps {
                sh "mvn sonar:sonar \
  -Dsonar.host.url=http://192.168.99.100:9000 \
  -Dsonar.login=a653d9ce3fce0829a8c5f23d3bfedd794f32afd6"
    }
        }
    }
}
