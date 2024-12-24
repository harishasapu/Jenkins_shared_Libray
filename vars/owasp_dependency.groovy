def call(){
  dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'DC'
  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
