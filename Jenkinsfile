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
        /*stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }*/

        //stage('Docker') {
        //    steps {
        //      docker.image('postgres').withRun('-e POSTGRES_PASSWORD=mysecretpassword') { //c ->
      /* Wait until mysql service is up */
      //sh 'while ! mysqladmin ping -h0.0.0.0 --silent; do sleep 1; done'
      /* Run some tests which require MySQL */
      //sh 'make check'
        //      }
        //    }
    //  }

	       stage('Sonar') {

            steps {
              //sh "mvn clean package sonar:sonar \
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

        /*stage('Update') {
            steps {
                echo 'Updating'
                sh "docker push localhost:5000/jetty-app-demo"
            }
        }*/

        /*stage('Run') {
          steps {
            sh 'mvn spring-boot:run'
          }
        }*/
    }
}
