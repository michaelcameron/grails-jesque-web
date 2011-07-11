package org.grails.plugin.jesqueweb

class JesqueStatsController extends JesqueController {

    def index = {
        def statType = params.statType
        if( !statType ) {
            redirect(action:index, params:[statType: "redis"])
            return
        }

        def model = [:]
        model.tabs = tabs
        model.activeTab = "Stats"
        model.subTabs = ["resque", "redis", "keys"]
        model.activeSubTab = statType

        switch(statType) {
            case "resque":
                model.title = "Resque Client connected to $jesqueConfig.URI"
                model.stats = createResqueStats()
                break
            case "redis":
                model.title = jesqueConfig.URI
                model.stats = keysDao.redisInfo
                break
            case "keys":
                model.title = "Keys owned by Resque Client connected to $jesqueConfig.URI"
                model.keys = keysDao.keyInfos
                break
        }

        model
    }

    private Map<String,Object> createResqueStats() {
		def resqueStats = [:]
		resqueStats.environment = "development"
		resqueStats.failed = failureDao.count
		resqueStats.pending =  queueInfoDao.pendingCount
		resqueStats.processed = queueInfoDa.processedCount
		resqueStats.queues = queueInfoDao.queueNames.size()
		resqueStats.servers = "[ $jesqueConfig.URI ]"
		resqueStats.workers = workerInfoDao.workerCount
		resqueStats.working = workerInfoDao.activeWorkerCount
		return resqueStats
	}
}
