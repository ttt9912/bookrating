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
            def doesJavaRock = input(message: 'Do you like Java?', ok: 'Yes', parameters: [booleanParam(defaultValue: true, description: 'If you like Java, just push the button',name: 'Yes?')])
            echo "Java rocks?:" + doesJavaRock
        }
        stage('Deploy-Trigger') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}