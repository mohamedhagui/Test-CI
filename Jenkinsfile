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
      stage('SonarQube quality tests') {
		    steps {
		    sh "mvn sonar:sonar -Dsonar.projectKey=project -Dsonar.host.url=http://192.168.1.160:9000 -Dsonar.login=e26a9552a516ed1fac3ae6dca2a739c97aa28e4a"
	        }
	    }
    }
}
