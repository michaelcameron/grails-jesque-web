class UrlMappings {

	static mappings = {
        "/jesque/queues/$queueName" (controller:"jesque", action:"queueDetail")
        		
        "/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}



		"/"(controller:"jesque")
		"500"(view:'/error')
	}
}
