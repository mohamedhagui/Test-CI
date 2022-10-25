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
           	    stage('Step mvn build') {
      		steps {
        		sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
      		}
    	}
         stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
           sh 'printenv'
           sh ' docker build -t samehbrdocker/validation:latest .'
           sh 'docker push samehbrdocker/validation:latest '
         }
       }
     }
        stage(" Step Docker-compose "){
            steps{
                sh 'docker-compose up -d '
            }
        }
    }
}
