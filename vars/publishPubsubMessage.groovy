def call(String projectId, String topicId, String message) {
    sh """python -m forest.pubsub.publishPubsubMessage --project_id=${projectId} \
            --topic_id=${topicId} --message=${message}"""
}