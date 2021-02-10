def call(String nexusUser, String nexusPassword, String projectId, String topicId, String message) {
    sh script: "pip install --extra-index-url ${extraIndexUrl} forest", returnStdout: true
    sh script: "python -m forest.pubsub.publish --project_id=${projectId} --topic_id=${topicId} " +
                "--message=${message}",
        returnStdout: true
}
