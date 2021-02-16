package com.nbc.ci

class PublishPubsubMessage {
    protected Object steps
    private String nexusUser
    private String nexusPassword

    PublishPubsubMessage(Object steps, String nexusUser, String nexusPassword) {
        this.steps = steps
        this.nexusUser = nexusUser
        this.nexusPassword = nexusPassword
    }
    
    private void install() {
        new File("keys.json").withWriter('utf-8') { 
            writer -> writer.write 'Hello World' 
        }
        
        File file = new File("keys.json") 
        println file.text
        
        def credentials = "${this.nexusUser}:${this.nexusPassword}"
        def extraIndexUrl = "https://${credentials}@nexus.bnc.ca/repository/9202-pypi-production-local/simple"
        this.steps.sh("python -m pip install --extra-index-url ${extraIndexUrl} forest forest-logging")
    }

    def publish(String projectId, String topicId, String message) {
        def isForestInstalled = this.steps.sh(script: "python -c \"from forest.pubsub.publisher import Publisher\"", returnStatus: true)
        this.steps.echo(isForestInstalled.toString())
        if(isForestInstalled != 0) {
            this.install()
        }
        this.steps.sh("python -m forest.pubsub.publish --project_id=${projectId} --topic_id=${topicId} " +
                    "--message=${message}")
    }
}
