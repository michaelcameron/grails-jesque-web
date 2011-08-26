package grails.plugin.jesqueweb

class JesqueQueuesController extends JesqueController {

    def index = {
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Queues"

        model.queueList = queueInfoDao.queueInfos
        model.totalFailureCount = failureDao.count

        model
    }

    def detail = {
        def queueName = params.id
        def offset = params.offset?.isInteger() ? params.offset.toInteger() : 0
        def max = params.max?.isInteger() ? params.max.toInteger() : 20
        def model = [:]

        model.offset = offset
        model.max = max
        
        model.queueName = queueName
        model.tabs = tabs
        model.activeTab = "Queues"

        model.subTabs = queueInfoDao.queueNames
        model.activeSubTab = queueName

        model.queue = queueInfoDao.getQueueInfo(queueName, offset, max)
        model.total = model.queue.size

        model
    }

    def remove = {
        def queueName = params.id

        queueInfoDao.removeQueue(queueName)

        redirect action:index
    }
}
