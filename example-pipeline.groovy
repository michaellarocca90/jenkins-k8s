def POD_LABEL = "testpod"
podTemplate(label:POD_LABEL, cloud: "jenkins-master", containers: [
    containerTemplate(name: 'build', image: 'node:12.13.1', ttyEnabled: true, command: 'cat')
  ]) {
    node(POD_LABEL) {
        stage('Run Shell') {
            container('build') {
                sh "sleep 30"
            }
        }
    }
}
