package grails.plugin.jesqueweb.test

class WorkingSpec extends AbstractFunctionalSpec {
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
