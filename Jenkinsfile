#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'scripts/jenkins/build.sh'
            }
        }
        //stage('Run') {
            //steps {
                //sh 'scripts/jenkins/run.sh'
            //}
        //}
    }
}
