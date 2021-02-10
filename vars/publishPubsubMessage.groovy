def call(String nexusUser, String nexusPassword, String projectId, String topicId, String message) {
    def credentials = "${nexusUser}:${nexusPassword}"
    def extraIndexUrl = "https://${credentials}@nexus.bnc.ca/repository/9202-pypi-production-local/simple"
    sh "python -m pip install --extra-index-url ${extraIndexUrl} forest"
    sh "python -m forest.pubsub.publish --project_id=${projectId} --topic_id=${topicId} --message=${message}"
}
