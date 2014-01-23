package com.soulsys.gserv.testapps.sourcecontrol.service
/**
 * Created by leecollins on 1/22/14.
 */
class Persistence {

    def _db

    def Persistence() {
        _db = mongo.getDB("gmongo")
    }

    def saveFile(groupId, artifactId, version, filename, fileContent) {

        def obj
        def ret = [:]
        def orig = getFile(groupId, artifactId, version, filename)
        if (orig) {
            orig.revision = orig.revision ?: 1
            obj = [
                    groupId: groupId,
                    artifactId: artifactId,
                    version: version,
                    filename: filename,
                    fileContent: fileContent,
                    revision: (orig.revision + 1)
            ]

        } else {
            obj = [
                    groupId: groupId,
                    artifactId: artifactId,
                    version: version,
                    filename: filename,
                    fileContent: fileContent,
                    revision: 1
            ]

        }

        _db.Files << obj
    }

    def getFile(groupId, artifactId, version, filename) {

        // get the file with the highest revision
        _db.Files.find([groupId: groupId, artifactId: artifactId, version: version, filename: filename])
                .sort({ revision: -1 })
                .limit(1)
    }

}
