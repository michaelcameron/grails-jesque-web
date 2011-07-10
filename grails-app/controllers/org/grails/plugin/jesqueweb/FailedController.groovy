package org.grails.plugin.jesqueweb

class FailedController extends JesqueController {

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
    
}
