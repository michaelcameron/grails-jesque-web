package org.grails.plugin.jesqueweb

class JesqueWorkersController extends JesqueController {

    def index = {
        def model = [:]
        model.tabs = tabs
        model.activeTab = "Workers"

        def hostMap = workerInfoDao.workerHostMap
		def viewName
		if (hostMap.size() == 1) {
            viewName = 'singleHost'
            model.workers = hostMap.values().asList()[0]
        } else {
            viewName = 'multipleHosts'
            model.hostMap = hostMap
            model.totalWorkerCount = hostMap.values().flatten().size()
        }

        render view:viewName, model:model
    }

    def detail = {
        def model = [:]
        model.tabs = tabs
        model.activeTab = "Workers"

        def workerName = params.id
        def workerInfo = workerInfoDao.getWorker(workerName)
        def hostMap = workerInfoDao.workerHostMap

        if( workerInfo ) {
            model.activeSubTab = workerInfo.host
            model.worker = workerInfo
        } else {
            redirect action:index
        }
        model.activeSubTabs = hostMap.keySet()

        model
    }
}
