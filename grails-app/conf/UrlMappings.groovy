class UrlMappings {

	static mappings = {
        println "in mappings"
        "/jesque/queues/$queueName" (controller:"jesque", action:"queueDetail")
        "/jesque/stats/$statType" (controller:"jesque", action:"stats")

        "/jesque/overview/$action?/$id?" { controller = "jesqueOverview" }
        "/jesque/queues/$action?/$id?" { controller = "jesqueQueues" }
        "/jesque/failed/$action?/$id?" { controller = "jesqueFailed" }
        "/jesque/stats/$action?/$id?" { controller = "jesqueStats" }
        "/jesque/workers/$action?/$id?" { controller = "jesqueWorkers" }
        "/jesque/working/$action?/$id?" { controller = "jesqueWorking" }
	}
}
