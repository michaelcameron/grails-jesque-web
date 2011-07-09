package org.grails.plugin.jesqueweb

import net.greghaines.jesque.meta.dao.QueueInfoDAO
import net.greghaines.jesque.meta.dao.FailureDAO
import net.greghaines.jesque.meta.dao.WorkerInfoDAO
import net.greghaines.jesque.meta.dao.KeysDAO
import net.greghaines.jesque.Config

class JesqueController {

    def tabs = ["Overview", "Working", "Failed", "Queues", "Workers", "Stats"]

    def index = { redirect action:overview }

    Config jesqueConfig
    QueueInfoDAO queueInfoDao
    FailureDAO failureDao
    WorkerInfoDAO workerInfoDao
    KeysDAO keysDao

    def overview = {
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Overview"

        model.queueList = queueInfoDao.queueInfos
        model.totalFailureCount = failureDao.count

        model.working = workerInfoDao.activeWorkers
        model.totalWorkerCount = workerInfoDao.workerCount

        model
    }

    def working = {
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Working"

        model.working = workerInfoDao.activeWorkers
        model.totalWorkerCount = workerInfoDao.workerCount

        model
    }

    def failed = {
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

    def queues = {
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Queues"

        model.queueList = queueInfoDao.queueInfos
        model.totalFailureCount = failureDao.count

        model
    }

    def queueDetail = {
        def queueName = params.queueName
        def offset = 0
        def max = 20
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Queues"

        model.subTabs = queueInfoDao.queueNames
        model.activeSubTab = queueName

        model.queue = queueInfoDao.getQueueInfo(queueName, offset, max)

        model
    }

    def stats = {
        def statType = params.statType
        if( !statType ) {
            redirect(action:stats, params:[statType:statType])
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

    private Map<String,Object> createResqueStats()
	{
		def resqueStats = [:]
		resqueStats.environment = "development"
		resqueStats.failed = failureDao.count
		resqueStats.pending =  queueInfoDao.pendingCount
		resqueStats.processed = queueInfoDao.processedCount
		resqueStats.queues = queueInfoDao.queueNames.size()
		resqueStats.servers = "[ $jesqueConfig.URI ]"
		resqueStats.workers = workerInfoDao.workerCount
		resqueStats.working = workerInfoDao.activeWorkerCount
		return resqueStats
	}
}
