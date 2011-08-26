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
        }
        build('net.sourceforge.nekohtml:nekohtml:1.9.14') {
            excludes "xml-apis"
        }

        test "org.codehaus.geb:geb-spock:0.6.0"

        plugins{
            compile(':redis:1.0.0.M7', ':jesque:0.11.M2')
            build(':release:1.0.0.M2') {
                excludes "xercesImpl", "xmlParserAPIs", "xml-apis", 'svn', 'nekohtml'
                export = false
            }
        }
    }
}