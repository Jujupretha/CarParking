Pipeline {
 Agent any 
Stage {
	Stage (‘Compile Stage’) {
Steps{
WithMaven(maven : ‘MAVEN_HOME’) {
	Sh ‘mvn  clean compile’
}
}
}
Stage (‘Testing Stage’) {
	Steps {
		withMaven(maven : ‘MAVEN_HOME’) {
		sh ‘mvn test’
}
}
}
Stage (‘Deployment stage’) {
Steps {
	withMaven(maven : ‘MAVEN_HOME’) {
	sh ‘mvn deploy’
}
}
}
}
}
