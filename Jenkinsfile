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
		    sh "mvn sonar:sonar -Dsonar.projectKey=alakey -Dsonar.host.url=http://192.168.1.21:9000 -Dsonar.login=97b2f538920a2c7396c095725ee092cd0e275c44"
	        }
	    }
		
		stage('DEPLOY NEXUS') {
			steps {
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		}
	   
	    
      
	
	   
	           
    }
}
