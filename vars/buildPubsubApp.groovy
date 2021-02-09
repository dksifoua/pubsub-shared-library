def call() {
    stage('Clone') {
        git branch: "feature/IAI-3045",
                url: "https://git.bnc.ca/scm/app9202/forest.git"
    }

    stage('Build') {
        sh """python -m pip install google-cloud-pubsub --trusted-host pypi.python.org \
                    --trusted-host files.pythonhosted.org --trusted-host pypi.org"""
    }
}