import com.nbc.ci.PublishPubsubMessage

def call(String nexusUser, String nexusPassword, String projectId, String topicId, String message) {
    docker = container.docker()
            .setImage('9202/python-ci-agent:1.0.0-production')
            .setRegistry('https://docker-production.bnc.ca')
            .setRegistryCredentials(context.getToolId('artifact-management'));
    return new PublishPubsubMessage(this, docker, nexusUser, nexusPassword, projectId, topicId, message)
}