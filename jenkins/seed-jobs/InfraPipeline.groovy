folder('ACE_ModelOps') {
    displayName('ACE_ModelOps')
    description('Folder for ACE_ModelOps')
}

 folder('ACE_ModelOps/Quality-bu') {
    multibranchPipelineJob('ACE_ModelOps/Quality-bu/infra') {
     branchSources {
      branchSource {
        source {
         git {
          id('seed-jobs')

 remote('https://github.com/quamarar/defect-correlation.git')
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
                scriptPath('jenkins/pipelines/Infra.Jenkinsfile')
            }
        }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
     }
   }
}



