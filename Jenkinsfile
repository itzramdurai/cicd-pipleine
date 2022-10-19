pipeline {  
    agent {label 'slave'}
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
            stage ('Initialize') {
                   steps {
                       sh '''
                       echo "PATH = ${PATH}"
                        M2_HOME='/opt/apache-maven-3.6.3'
                        PATH="$M2_HOME/bin:$PATH"
                        export PATH
                       echo "M2_HOME = ${M2_HOME}"
                       '''
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
            sh 'cp target/jenkins_calci-1.0-SNAPSHOT.war /opt/tomcat/apache-tomcat-9.0.8/webapps/jenkins_calci.war'
        }
        }
    }
}
