
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
}
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
    
}

