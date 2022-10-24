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
    	
    	 stage('JUNIT TEST') {
      		steps {
        		sh 'mvn test'
				
      		}
    	}
	    
/*	    stage('SONARQUBE') {
		    steps {
		    sh "mvn sonar:sonar -Dsonar.projectKey=ala -Dsonar.host.url=http://192.168.1.21:9000 -Dsonar.login=be9910f2524099f9c5e01c4f2a179db26113f8b1"
	        }
	    }
		
		stage('NEXUS') {
			steps {
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		} 
	    
*/	    
/*	 stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t alaboukhris/alaprojetcicd .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u alaboukhris -p ${dockerhubpwd}'

}
                   sh 'docker push alaboukhris/alaprojetcicd'
                }
            }
        }
	*/
	    
       stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
           
           sh 'docker build -t alaboukhris/alaprojetcicd:latest .'
           sh 'docker push alaboukhris/alaprojetcicd:latest'
         }
       }
     }
     
     stage('Run Spring & MySQL Containers') {
            steps {
                script {
                    sh 'docker-compose up -d'
                }
            }
        }
	           
    }
}
