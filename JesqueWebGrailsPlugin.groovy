import net.greghaines.jesque.meta.dao.impl.QueueInfoDAORedisImpl
import net.greghaines.jesque.meta.dao.impl.FailureDAORedisImpl
import net.greghaines.jesque.meta.dao.impl.KeysDAORedisImpl
import net.greghaines.jesque.meta.dao.impl.WorkerInfoDAORedisImpl

class JesqueWebGrailsPlugin {
    def version = "0.3.1"
    def grailsVersion = "1.3.0 > *"
    def dependsOn = [jesque:'0.3.0 > *']
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Jesque Web"
    def description = '''\\
Web interfce to view and manage jesque queues, jobs and workers.
'''

    def author = "Michael Cameron"
    def authorEmail = "michael.e.cameron@gmail.com"

    def license = "APACHE"
    def developers = [
        [ name: "Michael Cameron", email: "michael.e.cameron@gmail.com" ],
        [ name: "Ted Naleid", email: "contact@naleid.com" ] ]
    def documentation = "https://github.com/michaelcameron/grails-jesque-web"
    def scm = [ url: "https://github.com/michaelcameron/grails-jesque-web" ]

    def doWithWebDescriptor = { xml ->

    }

    def doWithSpring = {

    }

    def doWithDynamicMethods = { ctx ->
    }

    def doWithApplicationContext = { applicationContext ->
    }

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }
}
