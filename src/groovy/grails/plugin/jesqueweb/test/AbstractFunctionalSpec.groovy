package grails.plugin.jesqueweb.test

import geb.spock.GebReportingSpec
import org.codehaus.groovy.grails.commons.ApplicationHolder
import net.greghaines.jesque.meta.dao.WorkerInfoDAO
import grails.plugin.jesque.JesqueService

class AbstractFunctionalSpec extends GebReportingSpec{

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
}
