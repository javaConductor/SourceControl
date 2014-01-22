package com.soulsys.gserv.testapps.sourcecontrol.service

/**
 * Created by lcollins on 1/22/14.
 */
class SouceControlSvc {

	def getFile(groupId, artifactId, version){

	def ret  = [
		filename:"",
		fileContent:"",
		groupId:"",
		artifactId:"",
		version:""
	]

	}

	def saveFile(groupId, artifactId, version, fileContent){
		def ret  = [
				filename:"",
				groupId:"",
				artifactId:"",
				version:""
		]

	}


}
