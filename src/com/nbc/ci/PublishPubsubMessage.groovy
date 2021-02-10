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
    
    def install() {
        def credentials = "${this.nexusUser}:${this.nexusPassword}"
        def extraIndexUrl = "https://${credentials}@nexus.bnc.ca/repository/9202-pypi-production-local/simple"
        this.steps.sh("pip install --extra-index-url ${extraIndexUrl} forest")
    }

    def publish(String projectId, String topicId, String message) {
        this.steps.sh("python -m forest.pubsub.publish --project_id=${projectId} --topic_id=${topicId} " +
                    "--message=${message}")
    }
}
