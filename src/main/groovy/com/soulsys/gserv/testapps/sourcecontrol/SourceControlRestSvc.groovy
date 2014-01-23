package com.soulsys.gserv.testapps.sourcecontrol

import com.soulsys.g_serv.GServ

import javax.inject.Inject

/**
 * Created by leecollins on 1/22/14.
 */
class SourceControlRestSvc {

    @Inject
    def sourceControlSvc

    def SourceControlRestSvc(int port = 8082){


        def filesResource = GServ.resource("/files"){

            get{ ->
                /// get all files

            }

            get("/:groupId/:artifactId/:version/:filename") { groupId, artifactId, version, filename ->
                /// get latest revision of the specified file

            }

            post("/:groupId/:artifactId/:version/:filename") { fileContent, groupId, artifactId, version, filename ->
                // add new file


            }



        }


        GServ.http {

            resource(filesResource)
        }.start(port)

    }

}
