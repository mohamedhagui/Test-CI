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
	    
	    stage('SonarQube quality tests') {
		    steps {
		    sh "mvn sonar:sonar -Dsonar.projectKey=alakey -Dsonar.host.url=http://192.168.1.21:9000 -Dsonar.login=dbda1668b523d3a53bf4f12670e7a2873085d573"
	        }
	    }
	   
	    
      
	
	   
	           
    }
}