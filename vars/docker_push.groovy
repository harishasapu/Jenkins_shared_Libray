withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
}
