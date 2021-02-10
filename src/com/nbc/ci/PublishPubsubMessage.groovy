package com.nbc.ci

import com.nbc.helpers.ExecutionEnvironment

class PublishPubsubMessage {
    protected Object steps
    protected ExecutionEnvironment executionEnvironment
    private String nexusUser
    private String nexusPassword
    private String projectId
    private String topicId
    private String message

    PublishPubsubMessage(Object steps, ExecutionEnvironment executionEnvironment, String nexusUser, String nexusPassword,
                         String projectId, String topicId, String message) {
        this.steps = steps
        this.executionEnvironment = executionEnvironment
        this.nexusUser = nexusUser
        this.nexusPassword = nexusPassword
        this.projectId = projectId
        this.topicId = topicId
        this.message = message
    }

    def execute() {
        return this.executionEnvironment.exec {
            def credentials = "${this.nexusUser}:${this.nexusPassword}"
            def extraIndexUrl = "https://${credentials}@nexus.bnc.ca/repository/9202-pypi-production-local/simple"
            this.steps.sh(script: "pip install --extra-index-url ${extraIndexUrl} forest", returnStdout: true)
            this.steps.sh(
                script: "python -m forest.pubsub.publish --project_id=${this.projectId} --topic_id=${topicId} " +
                        "--message=${this.message}",
                returnStdout: true
            )
        }
    }
}