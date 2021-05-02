pipeline {
    agent { label 'slave'}
    stages {
        stage('Download Artifact from Nexus') {
            steps {
                echo 'Downloading Artifactory from Nexus'
                sh ''' wget -O jenkins_calci.war $Artifactid '''
            }
        }
        stage('Undeploy the existing war from Tomcat')
        {
            steps
            {
            sh 'sudo rm -rf /opt/tomcat/apache-tomcat-9.0.8/webapps/jenkins_calci.war'
        }
        }
         stage('CoolOff Period')
        {
            steps
            {
            sh 'sleep 10'
        }
        }
          stage('Deploy the war')
        {
            steps
            {
            sh 'sudo cp jenkins_calci.war /opt/tomcat/apache-tomcat-9.0.8/webapps/jenkins_calci.war'
        }
        }
    }
}
