package org.grails.plugin.jesqueweb

import net.greghaines.jesque.meta.dao.QueueInfoDAO
import net.greghaines.jesque.meta.dao.FailureDAO
import net.greghaines.jesque.meta.dao.WorkerInfoDAO

class JesqueController {

    def tabs = ["Overview", "Working", "Failed", "Queues", "Workers", "Stats"]

    def index = { redirect action:overview }

    QueueInfoDAO queueInfoDao
    FailureDAO failureDao
    WorkerInfoDAO workerInfoDao

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
}
