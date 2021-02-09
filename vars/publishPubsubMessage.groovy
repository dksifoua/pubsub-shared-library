def call(Map params) {
    sh """python -m forest.pubsub.publish --project_id=${params.projectId} \
            --topic_id=${params.topicId} --message=${params.message}"""
}