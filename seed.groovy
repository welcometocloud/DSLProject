
def gitUrl = "https://github.com/welcometocloud/DSLProject.git"

job("MyProject-Build") {
    description "Builds MyProject from master branch."
    parameters {
        stringParam('COMMIT', 'HEAD', 'Commit to build')
    }
    steps {
        sh ' "Look: I'm building master!" '
    }
}
