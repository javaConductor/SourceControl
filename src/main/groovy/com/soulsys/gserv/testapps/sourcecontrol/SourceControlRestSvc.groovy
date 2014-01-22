package com.soulsys.gserv.testapps.sourcecontrol

import com.soulsys.g_serv.GServ

/**
 * Created by leecollins on 1/22/14.
 */
class SourceControlRestSvc {



    def SourceControlRestSvc(int port = 8082){


        def filesResource = GServ.resource("/files"){

            get{ ->
                /// get all files

            }

            get("/:groupId/:artifactId/:version"){ id ->
                /// get all files

            }

            get{
                /// get all files

            }



        }



    }
}
