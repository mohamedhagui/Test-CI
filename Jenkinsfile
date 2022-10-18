pipeline{
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
        stage('Cleaning the project') {
            steps{
                sh "mvn -B -DskipTests clean  " 
            }
        }
        stage('Artifact Construction') {
            steps{
                sh "mvn -B -DskipTests package " 
            }
        }
        stage('sonar') {
            steps{
                sh "mvn sonar:sonar -Dsonar.projectKey=mohamed -Dsonar.host.url=http://192.168.1.17:9000 -Dsonar.login=21b448321dcbb4981f1a16791b0bfa5e6d51e8d9 "
            }
            stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipStaging=true -Dmaven.deploy.skip=true -Dmaven.deploy.skip=false'
                
            }        
        }
    }
}
