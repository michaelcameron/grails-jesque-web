package org.grails.plugin.jesqueweb

import net.greghaines.jesque.meta.dao.QueueInfoDAO
import net.greghaines.jesque.meta.dao.FailureDAO

class JesqueController {

    def tabs = ["Overview", "Working", "Failed", "Queues", "Workers", "Stats"]

    def index = { redirect action:overview }

    QueueInfoDAO queueInfoDao
    FailureDAO failureDao

    def overview = {
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Overview"
        model.queues = queueInfoDao.queueInfos
        model.totalFailureCount = failureDao.count

        model
    }
}
