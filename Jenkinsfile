pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        
        
      stage(' GIT ') {
            steps {
		  git config --global --unset https.proxy

                echo 'Pulliing ...';
                git branch: 'mohamed', url: 'https://github.com/Projet-CI/Test-CI.git'          
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
           
           sh 'docker build -t mohamed/mohamedprojetcicd:latest .'
           sh 'docker push mohamed/mohamedcicd:latest'
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
	   /*
	    stage('JUNIT TEST') {
      		steps {
        		sh 'mvn test'
				
      		}
    	}
	     */      
    }
}
/*pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        
        
      stage(' GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'mohamed', url: 'https://github.com/Projet-CI/Test-CI.git'          
            }
        }
        stage('CLEANING THE PROJECT') {
            steps{
                sh "mvn -B -DskipTests clean  " 
            }
        }
        stage('ARTIFACT CONSTRUCTION') {
            steps{
                sh "mvn -B -DskipTests package " 
            }
        }
               stage ('JUnit TEST') {
steps {
echo "Maven Test JUnit";
/*sh 'mvn test';*/
/*}
}
        stage('SONAR') {
            steps{
                sh "mvn sonar:sonar -Dsonar.projectKey=mohamed -Dsonar.host.url=http://192.168.1.17:9000 -Dsonar.login=21872257036352c8d6602ffaded9c3d144048010 "
            }
                
            }  
         stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipStaging=true -Dmaven.deploy.skip=true -Dmaven.deploy.skip=false -DskipTests'
            }
        }
   
    stage('EMAIL ALERT') {
        steps{
           emailext body: 'your pipeline was successfully built ! everything is good  ', subject: 'build done', to: 'guesmicr7@gmail.com'
        }
    }
    }
    
}/*
/*
