pipelineJob('Pipeline-Jenkinsfile-Demo') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/jabhishek87/jenkins-seed-jobs')
                        credentials('jabhishek-github-pat')
                    }
                }
            }
            scriptPath('jenkins_files/Jenkinsfile_1')
        }
    }
}