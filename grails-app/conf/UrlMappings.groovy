class UrlMappings {

	static mappings = {
        println "in mappings"
        "/jesque/queues/$queueName" (controller:"jesque", action:"queueDetail")
        "/jesque/stats/$statType" (controller:"jesque", action:"stats")

        "/jesque/$subcontroller/$action?/$id?" {
            controller = {
                def controllerName = "jesque" + params.subcontroller.capitalize()
                println "controllerName = $controllerName"
                return controllerName
            }
        }

		"/"(controller:"jesque/overview")
	}
}
