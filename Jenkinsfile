pipeline {
    agent any
    tools {
    	maven 'M2_HOME'
    }
    stages {
      
        stage('Checkout GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'ala', url: 'https://github.com/Projet-CI/Test-CI.git'          
            }
        }
        
          stage('Maven version') {
		    steps {
		    sh """mvn -version"""
	        }
	    }
      
	stage('Compiler') {
      		steps {
        		sh 'mvn compile'
      		}
    	}
	    stage('Build') {
      		steps {
        		sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
      		}
    	}
	   
	    
      
	
	   
	           
    }
}
