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

        stage('Docker') {

        docker.image('postgres').withRun('-e POSTGRES_PASSWORD=mysecretpassword') { //c ->
      /* Wait until mysql service is up */
      //sh 'while ! mysqladmin ping -h0.0.0.0 --silent; do sleep 1; done'
      /* Run some tests which require MySQL */
      //sh 'make check'
        }

        }

	       stage('Sonar') {

            steps {
              echo 'Sonar'
            //    sh "mvn clean package sonar:sonar \
            //    -Dsonar.host.url=http://192.168.99.100:9000 \
            //    -Dsonar.login=61a7ca03ba37b4921c9596147a17730c475fb9d4"
                }
        }
    }
}
