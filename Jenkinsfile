node {
    def mvnHome
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/mohammedtaher95/SeleniumJavaPOMFramework.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'MAVEN_HOME'
    }
    stage('Clean Old Builds') {
            // Run the maven build
            withEnv(["MVN_HOME=$mvnHome"]) {
                if (isUnix()) {
                    sh '"$MVN_HOME/bin/mvn" clean'
                } else {
                    bat(/"%MVN_HOME%\bin\mvn" clean/)
                }
            }
        }
    stage('Run Tests') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package -X'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package -X/)
            }
        }
    }
    stage('Results') {
        // testng '**/target/surefire-reports/TEST-*.xml'
        // archiveArtifacts 'target/*.jar'
        step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
        
    }
}
