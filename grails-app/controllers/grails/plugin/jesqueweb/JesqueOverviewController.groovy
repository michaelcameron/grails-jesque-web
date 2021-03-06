package grails.plugin.jesqueweb

class JesqueOverviewController extends JesqueController {

    def index = {
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Overview"

        model.queueList = queueInfoDao.queueInfos
        model.totalFailureCount = failureDao.count

        model.working = workerInfoDao.activeWorkers
        model.totalWorkerCount = workerInfoDao.workerCount

        model
    }
    
}
