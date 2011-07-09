class UrlMappings {

	static mappings = {
        "/jesque/queues/$queueName" (controller:"jesque", action:"queueDetail")
        "/jesque/stats/$statType" (controller:"jesque", action:"stats")
        		
        "/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}



		"/"(controller:"jesque")
		"500"(view:'/error')
	}
}
