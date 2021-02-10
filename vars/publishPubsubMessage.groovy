import com.nbc.ci.PublishPubsubMessage

def call(String nexusUser, String nexusPassword, String projectId, String topicId, String message) {
    container.docker()
            .setImage('9202/python-ci-agent:1.0.0-production')
            .setRegistry('https://docker-production.bnc.ca')
            .setRegistryCredentials(context.getToolId('artifact-management'))
            .exec {
                def credentials = "${nexusUser}:${nexusPassword}"
                def extraIndexUrl = "https://${credentials}@nexus.bnc.ca/repository/9202-pypi-production-local/simple"
                sh script: "pip install --extra-index-url ${extraIndexUrl} forest", returnStdout: true
                sh script: "python -m forest.pubsub.publish --project_id=${projectId} --topic_id=${topicId} " +
                            "--message=${message}",
                    returnStdout: true
            }
}