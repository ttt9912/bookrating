pipeline {
    agent {
        docker {
            image 'maven:3.3.3'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Performance') {
            steps {
                sh 'mvn verify'
            }
        }
        stage('Install') {
            steps {
                sh 'mvn install'
            }
        }
        stage('Confirm') {
            def userInput = input(
             id: 'userInput', message: 'Confirm?', parameters: [
             [$class: 'TextParameterDefinition', defaultValue: 'uat', description: 'Environment', name: 'env']
            ])
            echo ("Env: "+userInput)
        }
        stage('Deploy-Trigger') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}