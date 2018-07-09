pipeline {
    agent any

    tools {
        // jdk 'jdk8'
        maven 'jetty-app-maven'
    }

    stages {
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
                sh "mvn clean package sonar:sonar \
                -Dsonar.host.url=http://192.168.99.100:9000 \
                -Dsonar.login=61a7ca03ba37b4921c9596147a17730c475fb9d4"
                }
        }
    }
}
