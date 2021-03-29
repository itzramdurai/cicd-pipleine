pipeline {  
    agent any  
    stages {  
        stage('Checkout Repository'){
            steps{
                script {
                    try {
                        checkout([$class: 'GitSCM',
                        branches: [[name: "origin/${env.gitlabSourceBranch}" ]],
                        extensions: scm.extensions,
                        userRemoteConfigs: [[
                            url: 'git@gitlab.com:devopschef/jenkins/jenkinscicd.git',
                            credentialsId: "master"
                            ]]
                        ])
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
