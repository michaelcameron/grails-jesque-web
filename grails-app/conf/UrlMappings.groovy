class UrlMappings {

	static mappings = {
        println "in mappings"
        "/jesque/queues/$queueName" (controller:"jesque", action:"queueDetail")
        "/jesque/stats/$statType" (controller:"jesque", action:"stats")

        "/jesque/$controller/$action?/$id?" {
        }

		"/"(controller:"jesque/overview")
	}
}
