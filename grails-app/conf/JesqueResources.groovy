modules = {
    jesque {
        dependsOn 'jquery'

        resource url:[plugin: 'jesqueWeb', dir:'css', file:'reset.css']
        resource url:[plugin: 'jesqueWeb', dir:'css', file:'style.css']

        resource url:[plugin: 'jesqueWeb', dir:'js', file:'date.js']
        resource url:[plugin: 'jesqueWeb', dir:'js', file:'jquery.relatize_date.js']
        resource url:[plugin: 'jesqueWeb', dir:'js', file:'jesque.js']
    }
}