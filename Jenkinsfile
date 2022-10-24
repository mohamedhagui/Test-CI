pipeline {
    agent any 
    stages {
        stage('GIT') {
            steps {
                echo "get project";
                git "https://github.com/Projet-CI/Test-CI.git";
                  }
           }
           
        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
                  }
           }
           
        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
                  }
           }
           
  stage("Step Build "){
            steps{
                sh 'docker build -t samehbrdocker/validation . '
            }
        }
          stage(" Step Push "){
            steps{
                sh 'docker push samehbrdocker/validation '
            }
        }
        stage(" Step Docker-compose "){
            steps{
                sh 'docker-compose up -d '
            }
        }
    }
}
