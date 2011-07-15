package grails.plugin.jesqueweb

class JesqueWorkingController extends JesqueController {

    def index = {
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Working"

        model.working = workerInfoDao.activeWorkers
        model.totalWorkerCount = workerInfoDao.workerCount

        model
    }
    
}
