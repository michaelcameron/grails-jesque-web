package org.grails.plugin.jesqueweb

class WorkingController extends JesqueController {

    def index = {
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Working"

        model.working = workerInfoDao.activeWorkers
        model.totalWorkerCount = workerInfoDao.workerCount

        model
    }
    
}
