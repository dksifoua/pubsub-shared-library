def call() {
    git branch: "feature/IAI-3045",
            url: "https://git.bnc.ca/scm/app9202/forest.git"

    sh """python -m pip install google-cloud-pubsub --trusted-host pypi.python.org \
            --trusted-host files.pythonhosted.org --trusted-host pypi.org"""

    sh """pip install --extra-index-url=https://:@nexus.bnc.ca/repository/9202-pypi-production/simple forest-logging"""
}