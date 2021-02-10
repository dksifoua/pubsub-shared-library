import com.nbc.ci.PublishPubsubMessage

def call(String nexusUser, String nexusPassword) {
    return new PublishPubsubMessage(this, nexusUser, nexusPassword).publish("pot-ai-sandbox-8626", "test", "test")
}
