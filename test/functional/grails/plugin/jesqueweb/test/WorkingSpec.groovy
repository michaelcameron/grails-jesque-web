package grails.plugin.jesqueweb.test

import geb.spock.GebReportingSpec
import org.codehaus.groovy.grails.commons.ApplicationHolder
import net.greghaines.jesque.meta.dao.WorkerInfoDAO
import grails.plugin.jesque.JesqueService

class WorkingSpec extends GebReportingSpec {

    def redisService
    WorkerInfoDAO workerInfoDAO
    JesqueService jesqueService
    def grailsApplication

    def setup() {
        def context = ApplicationHolder.application.mainContext
        redisService = context.getBean("redisService")
        jesqueService = context.getBean("jesqueService")
        workerInfoDAO = context.getBean("workerInfoDao")
        redisService.flushDB()
    }

    def cleanup() {
        redisService.flushDB()
    }

    def "No workers"() {
        when:
        go('jesque/working')
        
        then:
        $().text() =~ "0 of 0 Workers Working"
    }

    def "1 Worker working"() {
        setup:
        def worker = jesqueService.startWorker("test", Object)

        when:
        go('jesque/working')
        worker.end(true)

        then:
        $().text() =~ "0 of 1 Workers Working"
    }
}
