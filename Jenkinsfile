pipeline {
    agent any 
    stages {
        stage('Step git') {
            steps {
                echo "get project";
                git "https://github.com/Projet-CI/Test-CI.git";
                  }
           }
           
        stage('Step mvn clean ') {
            steps {
                sh 'mvn clean'
                  }
           }
           
        stage('Step mvn compile') {
            steps {
                sh 'mvn compile'
                  }
           }
           
         stage("Step Build "){
            steps{
                sh 'docker build -t validation . '
            }
        }
          stage(" Step Push "){
            steps{
                sh 'docker push validation '
            }
        }
        stage(" Step Docker-compose "){
            steps{
                sh 'docker-compose up -d '
            }
        }
    }
}
