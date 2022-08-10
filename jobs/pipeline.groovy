pipelineJob('job-name') {
  definition {
    cps {
      script('''
        pipeline {
        agent any
        stages {
            stage("Environment Setup"){
                steps{
                    wrap([$class: 'BuildUser']) {
                        sh 'echo "${BUILD_USER}"'
                        echo "Env setup"
                        // clean workspace Delete workspace before build startsss
                        //cleanWs()
                    }
                }
            }

            stage('Logs Processing'){
                steps {
                    echo "Logs Processing"
                    echo env.BUILD_URL
                    echo env.JOB_URL
                }
            }
            stage('Shell Builder'){
                steps {
                    shell('echo "Hello World!"')
                }
            }

        }
        }
    ''')
    }
  }
}