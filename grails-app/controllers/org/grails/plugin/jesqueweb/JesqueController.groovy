package org.grails.plugin.jesqueweb

import net.greghaines.jesque.meta.dao.QueueInfoDAO
import net.greghaines.jesque.meta.dao.FailureDAO
import net.greghaines.jesque.meta.dao.WorkerInfoDAO
import net.greghaines.jesque.meta.dao.KeysDAO
import net.greghaines.jesque.Config

abstract class JesqueController {

    def tabs = ["Overview", "Working", "Failed", "Queues", "Workers", "Stats"]

    Config jesqueConfig
    QueueInfoDAO queueInfoDao
    FailureDAO failureDao
    WorkerInfoDAO workerInfoDao
    KeysDAO keysDao
}
