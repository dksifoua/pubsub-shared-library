import com.nbc.ci.PublishPubsubMessage

def call(String nexusUser, String nexusPassword) {
    def forestInstalled = sh(script: "python -c \"import forest\"", returnStdout: true).trim()
    echo "Is Forest installed? ${forestInstalled}"
    return new PublishPubsubMessage(this, nexusUser, nexusPassword)
}
