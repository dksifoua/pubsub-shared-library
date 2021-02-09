def call(Closure body) {
    node {
        stage('Clone') {
            steps {
                git branch: "feature/IAI-3045",
                        url: "https://git.bnc.ca/scm/app9202/forest.git"
            }
        }

        stage('Build') {
            steps {
                sh """python -m pip install google-cloud-pubsub --trusted-host pypi.python.org \
                    --trusted-host files.pythonhosted.org --trusted-host pypi.org"""
            }
        }

        body()
    }
}