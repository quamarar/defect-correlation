multibranchPipelineJob('ACE_ModelOps/Quality-bu/Inference') {
    branchSources {
      branchSource {
        source {
         git {
          id('sample-app')
          remote('https://gitlab.com/tarandeepsingh009/infrastructure.git')
          credentialsId('gitlab-token')
          }
        }
        strategy {
                    defaultBranchPropertyStrategy {
                        props {
                            noTriggerBranchProperty()
                       }
                  }
             }
         }
    }
    configure {
        def traits = it / sources / data / 'jenkins.branch.BranchSource' / source / traits
        traits << 'jenkins.plugins.git.traits.BranchDiscoveryTrait' {}
    }
        factory {
            workflowBranchProjectFactory {
                scriptPath('jenkins/pipelines/Inference.Jenkinsfile')
            }
        }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
     }
   }

