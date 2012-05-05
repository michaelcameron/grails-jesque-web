grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
        mavenRepo "http://snapshots.repository.codehaus.org"
        mavenRepo "http://repository.codehaus.org"
        mavenRepo "http://download.java.net/maven/2/"
        mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:2.3.1") {
            excludes "xercesImpl", "xmlParserAPIs", "xml-apis", "xerces", "commons-logging"
            export = false
        }
        build('net.sourceforge.nekohtml:nekohtml:1.9.14') {
            excludes "xml-apis"
            export = false
        }

        test("org.codehaus.geb:geb-spock:0.6.0") {
            export = false
        }

        build('net.greghaines:jesque:1.0.1',
                'org.codehaus.jackson:jackson-core-asl:1.8.4',
                'org.codehaus.jackson:jackson-mapper-asl:1.8.4',) {
            transitive = false
        }
    }
    plugins{
        compile(':redis:1.0.0.M9')
        compile(':jesque:0.3.0')
        compile(':resources:1.1.6')
        build(":hibernate:$grailsVersion")
        build(":tomcat:$grailsVersion")

        test(':geb:0.6.3',':spock:0.6') {
            export = false
        }
        build(':release:1.0.1') {
            export = false
        }
        compile(':jquery:1.7.1') {
            transitive = false
        }
    }
}

//grails.plugin.location.jesque = "../grails-jesque"