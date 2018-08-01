pipeline {
    agent any

      tools {
        // jdk 'jdk8'
        maven 'jetty-app-maven'
    }

    stages {
        stage('Clean') {
            steps {
                echo 'Cleaning..'
                sh "mvn clean"
                // sh "mvn package"
                // sh "mvn validate"
                //  sh "mvn compile"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "mvn test"
            }
        }

	       stage('Sonar') {
            steps {
              sh "mvn sonar:sonar \
                -Dsonar.host.url=http://192.168.99.100:9000"
                //-Dsonar.login=61a7ca03ba37b4921c9596147a17730c475fb9d4"
                }
        }

        stage('Package') {
          steps {
            echo 'Package'
            sh 'mvn package'
          }
        }

        stage('Build') {
            steps {
                echo 'Building..'
                sh "docker build -t jetty-app-demo ."
                //app = docker.build("test")
            }
        }

        stage('Update') {
            steps {
                echo 'Updating'
                sh "docker tag jetty-app-demo localhost:5000/jetty-app-demo"
                sh "docker push localhost:5000/jetty-app-demo"
            }
        }

        stage('Cleanup') {
          steps {
            echo 'Cleanup'
            sh 'mvn clean'
            sh 'docker image rm localhost:5000/jetty-app-demo'
            sh 'docker image rm jetty-app-demo'
          }
        }

        /*stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }*/

        /*stage('Run') {
          steps {
            sh 'mvn spring-boot:run'
          }
        }*/

    }
}
