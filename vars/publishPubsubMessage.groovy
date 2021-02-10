import com.nbc.ci.PublishPubsubMessage

def call(String nexusUser, String nexusPassword) {
    def pubsub = new PublishPubsubMessage(this, nexusUser, nexusPassword)
    pubsub.install()
    return pubsub
}
