pipeline {
  agent any

  parameters {
    string(name: 'BASE_URL', defaultValue: 'http://ga-int-alb-2103090581.eu-west-1.elb.amazonaws.com', description: 'ga base url')
    string(name: 'V_USERS', defaultValue: '1', description: 'Number of virtual users')
  }

  options {
    disableConcurrentBuilds()
    buildDiscarder(logRotator(numToKeepStr: '3'))
  }

  tools {
    maven "maven-3.6.0"
    jdk "jdk-8"
  }

  stages {
    stage('Stress Test') {
      steps {
        sh """
          mvn gatling:test \
            -Dproxy_host=fr000-proxy002 \
            -Dproxy_port=8080 \
            -Dbase_url=${BASE_URL} \
            -Dv_users=${V_USERS}
          """
        gatlingArchive()
      }
    }
  }
}
