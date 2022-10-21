pipeline {
    agent any
    tools{
        maven 'maven'
      }

    stages{

        stage('Build'){
            steps{
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE'){
                      sh 'mvn package -DskipTests'
            }
               
            }
         }

        stage('Sonarqube'){
            environment{
                scannerHome = tool 'sonarscanner'
            }    
            steps{
                withSonarQubeEnv('sonarqube'){
                    sh "mvn sonar:sonar -Dsonar.projectKey=projet-ci "
                }         
            }
        }
        
        stage("publish  war file on nexus"){
            steps{
               script{
                    
                nexusArtifactUploader artifacts: [[artifactId: 'spring-boot-starter-parent', classifier: '', file: 'target/achat-1.0.jar', type: 'jar']], credentialsId: 'c655f4b5-82b0-4561-ac13-60c5e6b41770', groupId: 'org.springframework.boot', nexusUrl: 'localhost:8081', nexusVersion: 'nexus2', protocol: 'http', repository: 'http://localhost:8081/repository/jenkins/', version: '2.5.3'
                 
                }
            }
        }  
            
        stage("Build docker image"){
            steps{
                sh 'docker build -t zeynebsd/projet-ci . '
            }
        }
    }
        /*  post {
          always 
          {
            script 
            {
            def url = "${env.BUILD_URL}"
            def status = currentBuild.currentResult
            def color = status == 'SUCCESS' ? '#00FF00' : '#FF0000'
            def resultIcon = status == 'SUCCESS' ? ':white_check_mark:' : ':anguished:'
            slackSend (message: "${resultIcon} Jenkins Build $currentBuild.currentResult\n\nResults available at: [ Jenkins-$env.JOB_NAME#$env.BUILD_NUMBER ] \n ${url}", 
                        color: color)
            }
          }
      }*/
} 
