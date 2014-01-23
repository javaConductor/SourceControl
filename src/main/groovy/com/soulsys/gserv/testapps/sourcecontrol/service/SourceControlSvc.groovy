package com.soulsys.gserv.testapps.sourcecontrol.service

/**
 * Created by lcollins on 1/22/14.
 */
class SourceControlSvc {

    def getFile(groupId, artifactId, version, filename) {


        def ret = [
                filename: filename,
                fileContent: fileContent,
                groupId: "",
                artifactId: "",
                version: "",
                revision: ""
        ]
    }

    def saveFile(groupId, artifactId, version, filename, fileContent) {
        def ret  = [
				filename:"",
				groupId:"",
				artifactId:"",
				version:""
		]

	}


}
