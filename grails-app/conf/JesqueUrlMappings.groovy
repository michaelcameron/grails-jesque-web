class JesqueUrlMappings {

    static mappings = {
        "/jesque/overview/$action?/$id?" { controller = "jesqueOverview" }
        "/jesque/queues/$action?/$id?" { controller = "jesqueQueues" }
        "/jesque/failed/$action?/$id?" { controller = "jesqueFailed" }
        "/jesque/stats/$action?/$id?" { controller = "jesqueStats" }
        "/jesque/workers/$action?/$id?" { controller = "jesqueWorkers" }
        "/jesque/working/$action?/$id?" { controller = "jesqueWorking" }

        "/jesque" (controller: "jesqueOverview")
    }
}
