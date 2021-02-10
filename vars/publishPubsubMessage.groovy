import com.nbc.ci.PublishPubsubMessage

def call(String nexusUser, String nexusPassword, String projectId, String topicId, String message) {
    return new PublishPubsubMessage(this, nexusUser, nexusPassword)
}
