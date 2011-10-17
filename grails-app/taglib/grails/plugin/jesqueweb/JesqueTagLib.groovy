package grails.plugin.jesqueweb

import net.greghaines.jesque.utils.ResqueDateFormatThreadLocal
import net.greghaines.jesque.json.ObjectMapperFactory
import net.greghaines.jesque.utils.JesqueUtils
import net.greghaines.jesque.JobFailure

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
        out << ObjectMapperFactory.get().writeValueAsString(attr.value)
    }

    def asBacktrace = {attr, body ->
        if( attr.exception ) {
            out << (attr.exception ? JesqueUtils.createBacktrace(attr.exception).join("\n") : null)
        } else if(attr.failure) {
            JobFailure jobFailure = attr.failure
            out << jobFailure.backtrace?.join("\n")
        }
    }
}
