def call(String nexusUser, String nexusPassword, String projectId, String topicId, String message) {
    container.docker()
            .setImage('9202/python-ci-agent:1.0.0-production')
            .setRegistry('https://docker-production.bnc.ca')
            .setRegistryCredentials(context.getToolId('artifact-management'))
            .exec {
                echo "${nexusUser} ${nexusPassword} ${projectId} ${topicId} ${message}"
            }
}
