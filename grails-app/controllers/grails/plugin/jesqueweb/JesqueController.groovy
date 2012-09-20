package grails.plugin.jesqueweb

import net.greghaines.jesque.meta.dao.QueueInfoDAO
import net.greghaines.jesque.meta.dao.FailureDAO
import net.greghaines.jesque.meta.dao.WorkerInfoDAO
import net.greghaines.jesque.meta.dao.KeysDAO
import net.greghaines.jesque.Config
import net.greghaines.jesque.utils.VersionUtils
import grails.plugin.jesque.ScheduledJobDaoService
import grails.plugin.jesque.TriggerDaoService

abstract class JesqueController {

    def tabs = ["Overview", "Working", "Failed", "Queues", "Workers", "Stats", "Scheduled"]

    Config jesqueConfig
    QueueInfoDAO queueInfoDao
    FailureDAO failureDao
    WorkerInfoDAO workerInfoDao
    KeysDAO keysDao
    def scheduledJobDaoService
    TriggerDaoService triggerDaoService

    def afterInterceptor = { model ->
        model.version = VersionUtils.version
        model.namespace = jesqueConfig.namespace
        model.redisUri = jesqueConfig.URI
    }
}
