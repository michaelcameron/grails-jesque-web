package grails.plugin.jesqueweb

import net.greghaines.jesque.meta.dao.QueueInfoDAO
import net.greghaines.jesque.meta.dao.FailureDAO
import net.greghaines.jesque.meta.dao.WorkerInfoDAO
import net.greghaines.jesque.meta.dao.KeysDAO
import net.greghaines.jesque.Config
import net.greghaines.jesque.utils.VersionUtils

abstract class JesqueController {

    def tabs = ["Overview", "Working", "Failed", "Queues", "Workers", "Stats"]

    Config jesqueConfig
    QueueInfoDAO queueInfoDao
    FailureDAO failureDao
    WorkerInfoDAO workerInfoDao
    KeysDAO keysDao

    def afterInterceptor = { model ->
        model.version = VersionUtils.version
        model.namespace = jesqueConfig.namespace
        model.redisUri = jesqueConfig.URI
    }
}
