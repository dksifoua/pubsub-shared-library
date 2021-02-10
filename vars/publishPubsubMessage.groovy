def call(String nexusUser, String nexusPassword, String projectId, String topicId, String message) {
    sh "pip install --extra-index-url ${extraIndexUrl} forest"
    sh "python -m forest.pubsub.publish --project_id=${projectId} --topic_id=${topicId} --message=${message}"
}
