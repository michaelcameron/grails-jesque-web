package org.grails.plugin.jesqueweb

import net.greghaines.jesque.utils.ResqueDateFormatThreadLocal
import net.greghaines.jesque.json.ObjectMapperFactory
import net.greghaines.jesque.utils.JesqueUtils

class JesqueTagLib {

    static namespace = 'jesque'

    def workerShortName = { attr, body ->
        def workerName = attr.workerName

        out << (workerName ? workerName.split(':')[0..1].join(':') : null)
    }

    def formatDate = {attr, body ->
        out << (attr.date ? ResqueDateFormatThreadLocal.getInstance().format(attr.date) : null)
    }

    def showArgs = {attr, body ->
        out << attr.args?.collect{ ObjectMapperFactory.get().writeValueAsString(it) }?.join("\n")
	}


	def toJson = {attr, body ->
		ObjectMapperFactory.get().writeValueAsString(attr.value)
	}


    def asBacktrace = {attr, body ->
        def exception = attr.exception

        out << (exception ? JesqueUtils.createBacktrace(exception).join("\n") : null)
	}
}
