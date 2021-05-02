 Make a new jenkins pipeline

### What it will do?

what it will do?

The code has 2 pipelines basically. One for Building the Application and other for deploying the app to tomcat server

### build.groovy

build.groovy will run the following stages

+ Fetch your sourcecode from Gitlab
+ Compile it
+ Make its build ( a .war file)
+ Test it using selenium (basic)
+ Push your artiacts to Nexus artifactory server

### deploy.groovy

deploy.groovy will run the following stages

+ Fetch your artifacts from Nexus
+ Undeploy the war file from tomact server
+ Sleep for 10s as cooling period
+ Deploy the downloaded artifacts to tomcat (webapps)

pipeline will do all its job stage by stage and you will get outputs like (for every successfull job!)

### Check your Web Application

open your tomcat url along with the context path provided.
