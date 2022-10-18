pipeline {
    agent any
    tools {
    	maven 'M2_HOME'
    }
    stages {
      
        stage(' GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'ala', url: 'https://github.com/Projet-CI/Test-CI.git'          
            }
        }
        
          stage('MVN VERSION') {
		    steps {
		    sh """mvn -version"""
	        }
	    }
      
	stage('COMPILING') {
      		steps {
        		sh 'mvn compile'
      		}
    	}
	    stage('MVN BUILD') {
      		steps {
        		sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
      		}
    	}
	    
	    stage('SONARQUBE') {
		    steps {
		    sh "mvn sonar:sonar -Dsonar.projectKey=alakey -Dsonar.host.url=http://192.168.1.21:9000 -Dsonar.login=dbda1668b523d3a53bf4f12670e7a2873085d573"
	        }
	    }
		
		stage('NEXUS') {
			steps {
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		} 
	           
    }
}
