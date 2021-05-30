pipeline {  
    agent {
        label 'agent1'
    }  
    stages {  
        stage('Checkout Repository'){
            steps{
                script {
                    try {
                    git credentialsId: 'gitlab', url: 'https://gitlab.com/thedevopschef/cicd-pipleine.git'
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
            stage ('Push Artifacts to Nexus') {  
                  steps{
                    sh 'mvn deploy'
                    echo "deploy  successful";
                } 
            }
    }
}
