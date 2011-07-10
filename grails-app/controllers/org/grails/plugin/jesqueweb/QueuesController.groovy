package org.grails.plugin.jesqueweb

class QueuesController extends JesqueController {

    def index = {
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
