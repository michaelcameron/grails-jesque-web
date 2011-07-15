package grails.plugin.jesqueweb

class JesqueFailedController extends JesqueController {

    def index = {
        def offset = 0
        def max = 20
        def model = [:]
        model.tabs = tabs
        model.activeTab = "Failed"

        model.offset = offset
        model.max = max
        model.fullFailureCount = failureDao.count
        model.failures = failureDao.getFailures(offset, max)

        model
    }

    def requeue = {
        String id = params.id
        if( id.isLong() )
            failureDao.requeue(id.toLong())

        redirect action:index
    }

    def remove = {
        String id = params.id
        if( id.isLong() )
            failureDao.remove(id.toLong())

        redirect action:index
    }
}
