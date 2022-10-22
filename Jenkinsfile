pipeline {  
    agent {label 'slaveMachine'}
    tools {
        maven 'maven' 
    }
    stages {  
        stage('Checkout Repository'){
            steps{
                script {
                    try {
                    git url: 'https://github.com/itzramdurai/cicd-pipleine.git'
                    }
                    catch (Exception e) {
                        throw e
                    }
                }
            }
        }
            stage ('Compile') {  
                  steps{
                     sh 'mvn compile'
                    echo "test successful";          
                } 
            }
            stage ('Build') {  
                  steps{
                    sh 'mvn clean'
                    sh 'mvn package'
                    echo "build successful";
                    
                } 
            }
             stage ('Test') {  
                  steps{
                    sh 'mvn test'
                    echo "test successful";
                } 
            }
          stage('Deploy the war to tomcat')
        {
            steps
            {
            sh 'ls -lrt target/'
            sh 'cp target/jenkins_calci-1.0-SNAPSHOT.war /opt/tomcat/webapps/jenkins_calci.war'
        }
        }
    }
}
