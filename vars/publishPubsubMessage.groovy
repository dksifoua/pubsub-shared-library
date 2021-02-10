import com.nbc.ci.PublishPubsubMessage

def call(String nexusUser, String nexusPassword) {
    def pubsub = new PublishPubsubMessage(this, nexusUser, nexusPassword)
    pubsub.install()
    pubsub.publish("pot-ai-sandbox-8626", "test", "test")
    return pubsub
}
