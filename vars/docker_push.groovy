def call(String Project, String ImageTag, String dockerhubuser) {
    // Use Jenkins credentials binding to securely inject the username and password
    withCredentials([usernamePassword(credentialsId: 'docker', 
                                      passwordVariable: 'DOCKER_PASSWORD', 
                                      usernameVariable: 'DOCKER_USERNAME')]) {
        // Securely login to Docker using --password-stdin
        sh '''
        echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin
        '''
    }

    // Push the image to Docker Hub using the provided project and image tag
    sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
