pipeline {
    agent any 
    stages {
        stage('GIT') {
            steps {
                echo "get project";
                git "https://github.com/Projet-CI/Test-CI.git";
                  }
           }
           
        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
                  }
           }
           
        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
                  }
           }
           
        stage('MVN SONARQUBE') {
            steps {
                sh mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                  }
           }
        
        stage('MVN JUNIT') {
            steps {
                echo "Test junit"
                  }
           }
           
        stage('MVN NEXUS') {
            steps {
                sh 'mvn deploy'
                  }
           }
    }
}
