package grails.plugin.jesqueweb

class JesqueScheduledController extends JesqueController {

    def index = {
        def model = [:]
        model.tabs = tabs
        model.activeTab = "Scheduled"

        model.scheduledJobs = scheduledJobDaoService.all

        model
    }
}
