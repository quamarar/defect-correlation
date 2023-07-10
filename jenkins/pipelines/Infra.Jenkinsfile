pipeline {
  agent any


    stages {
        stage('Initialise terraform directory') {
            steps{
                dir('infra') {
                    sh 'terraform init -no-color'
                }
            }
        }
  
        stage('Terraformplan') {
            steps{
                dir('infra') {
                     sh 'terraform plan -no-color  -input=false -out=tfplan'
                }
            }
        }

        stage('apply') {
            steps {
                dir('infra') {
                sh 'terraform apply -no-color -input=false tfplan'
            }
          }
        } 
       
    }
 
} 


