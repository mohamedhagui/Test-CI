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
		    sh "mvn sonar:sonar -Dsonar.projectKey=ala -Dsonar.host.url=http://192.168.1.21:9000 -Dsonar.login=be9910f2524099f9c5e01c4f2a179db26113f8b1"
	        }
	    }
		
		stage('NEXUS') {
			steps {
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		} 
	    
	    
	     stage('BUILD DOCKER IMAGE'){
                     steps{
			     sh 'printenv'
                             sh 'docker build -t alaboukhris/projetci:""$BUILD_ID"" . '
            }
        }
          stage("PUSH"){
            steps{
		    withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
                    sh 'docker push alaboukhris/projetci:""$BUILD_ID""'
            }
           }
	 }
	           
    }
}
