pipeline {
    agent any

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
                sh "mvn sonar:sonar \
  -Dsonar.host.url=http://192.168.99.100:9000 \
  -Dsonar.login=a653d9ce3fce0829a8c5f23d3bfedd794f32afd6"
    }
        }
    }
}
