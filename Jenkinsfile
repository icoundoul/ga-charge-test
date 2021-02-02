pipeline {
   agent any

    parameters {
        choice(choices: ['int','preprod', 'prod'], description: 'Quel environnement ?', name: 'env')
    }

    tools {
        maven 'maven-3.6.0'
		jdk 'jdk-8'
    }

    options {
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '3'))
    }
	
	triggers {
        pollSCM 'H/59 * * * *'
    }

    stages {
        stage('Clean') {
            steps {
                deleteDir()
            }
        }

        stage('Clone') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh "echo ${params.env}"
                sh "mvn clean install -P${params.env},livraison "
            }
        }
	stage('Email notification') {
		    steps {
		mail bcc: '', body: '''Hello,
		Ceci est une notification mail du job
		Thanks''', cc: '', from: '', replyTo: '', subject: 'Jenkins job', to: 'coundoulamathmaty@gmail.com'
			    }
	} 
    }
}

