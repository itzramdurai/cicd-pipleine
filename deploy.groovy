pipeline {
    agent any
    stages {
        stage('Download Artifact from Nexus') {
            steps {
                echo 'Downloading Artifactory from Nexus'
                sh ''' wget -O jenkins_calci.war $ArticactID '''
            }
        }
        stage('Undeploy the existing war from Tomcat')
        {
            steps
            {
            sh 'curl "http://admin:admin@localhost:9090/manager/undeploy?path=/jenkins_calci"'
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
            sh 'curl -X POST --upload-file jenkins_calci.war "http://admin:admin@localhost:9090/manager/deploy?path=/jenkins_calci"'
        }
        }
    }
}
