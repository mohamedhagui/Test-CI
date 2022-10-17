pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        stage('Checkout GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'sameh', url: 'https://github.com/Projet-CI/Test-CI.git'          
            }
        }
        stage('Cleaning the project') {
            steps{
                sh "mvn -B -DskipTests clean  " 
            }
        }
          stage('Compiler') {
      		steps {
        		sh 'mvn compile'
      		}
    	}
        stage('Artifact Construction') {
            steps{
                sh "mvn -B -DskipTests package " 
            }
        }
      
    }
}
