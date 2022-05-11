import org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval

ScriptApproval scriptApproval = ScriptApproval.get()
scriptApproval.pendingScripts.each {
    scriptApproval.approveScript(it.hash)
}

def gitUrl = "https://github.com/welcometocloud/DSLProject.git"

job("MyProject-Build") {
    description "Builds MyProject from master branch."
    parameters {
        stringParam('COMMIT', 'HEAD', 'Commit to build')
    }
    scm {
        git {
            remote {
                url gitUrl.
            }
            extensions {
                wipeOutWorkspace()
                localBranch main
            }
        }
    }
    steps {
        shell "Look: I'm building master!"
    }
    post { 
        always { 
            cleanWs()
        }
    }
}
