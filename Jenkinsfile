pipeline {
    agent any

    stages {

        stage(' test withCredentials ') {
            steps {
                withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'Logic-Test', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                    // 在这里，您可以使用环境变量 AWS_ACCESS_KEY_ID 和 AWS_SECRET_ACCESS_KEY
                    sh 'echo $AWS_ACCESS_KEY_ID'
                    sh 'echo $AWS_SECRET_ACCESS_KEY'
                    sh("chmod +x ./src/test_with_credentials.py ")
                    sh("python3 ./src/test_with_credentials.py --get_secret True")

                }
                echo 'Credentials SUCCESS'
            }
         }

        stage ('Compile QA') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing QA') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Deployment QA') {
            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}