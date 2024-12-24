def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "echo ${dockerHubPass} | docker login -u ${dockerhubuser} --password-stdin"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
