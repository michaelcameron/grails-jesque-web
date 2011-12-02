package grails.plugin.jesqueweb

import net.greghaines.jesque.meta.KeyType

class JesqueStatsController extends JesqueController {

    def index = {
        redirect action:detail, id:params.statType
    }

    def detail = {
        def statType = params.id
        if( !statType ) {
            redirect(action:detail, id:"redis")
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

    def keys = {
        def key = params.id
        def offset = params.offset
        def max = params.max
        offset = offset?.isInteger() ? offset.toInteger() : 0
        max = max?.isInteger() ? max.toInteger() : 20

        def model = [:]

        model.tabs = tabs
        model.activeTab = "Stats"
        model.subTabs = ["resque", "redis", "keys"]
        model.activeSubTab = "keys"

        def viewName
        def keyInfo = keysDao.getKeyInfo(jesqueConfig.namespace + ':' + key, offset, max)
        if(!keyInfo) {
            viewName = 'keyString'
            model.keyName = key
        } else if(keyInfo.type == KeyType.STRING) {
            viewName = 'keyString'
            model.key = keyInfo
        } else {
            viewName = 'keySet'
            model.key = keyInfo
            model.max = max
            model.offset = offset
            model.total = keyInfo.size
        }

        render view:viewName, model:model
    }

    private Map<String,Object> createResqueStats() {
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
