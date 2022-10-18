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
                sh 'mvn sonar:sonar -Dsonar.projectKey=alakey -Dsonar.host.url=http://192.168.1.21:9000 -Dsonar.login=97b2f538920a2c7396c095725ee092cd0e275c44'
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
