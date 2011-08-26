package grails.plugin.jesqueweb.test

import geb.spock.GebReportingSpec
import org.junit.Test
import geb.spock.GebSpec
import org.spockframework.compiler.model.Spec
import grails.plugin.spock.IntegrationSpec

class TestSpec extends IntegrationSpec {

    def redisService

    @Test
    def "test Dependency injection"() {
        when:
        redisService.flushDB()

        then:
        true
    }
}
