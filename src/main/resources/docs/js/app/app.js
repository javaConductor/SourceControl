'use strict';

var theModule = angular.module('SourceControl', [
      'ngResource'
    ]);

function SourceControlController($scope, $location, sourceControl){
    console.log("SourceControlController() created.")

    console.log("MathController() creating REST resource.");
    $scope.restSvc = $resource('/:operation/:number1/:number2', {});

      $scope.edit = {
            groupId : '',
            artifactId: ''
            version: '',
            filename: '',
            fileContent:''
      }
      
      $scope.list = []
      $scope.reportError = function(errorMsg){
            console.log(errorMsg)
      }
      $scope.saveArtifact = function(){
            if(!edit.groupdId || !edit.artifactId || !edit.version || !edit.fileContent)
            return;
            var result =sourceControl.save(edit.groupId, edit.artifactId, edit.version, edit.fileContent)
            if (result.error){
                  $scope.reportError(result.error)
            }            
      }

    console.log("SourceControlController() DONE!")
    return this;
  };
SourceControlController.$inject = ["$scope", "$location", "SourceControlService"]

theModule.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/index.html',
        controller: "SourceControlController"
      })
      .otherwise({
        redirectTo: '/'
      });
  });

theModule.factory('SourceCodeService', ['$resource', '$location', function ($resource, $location) {
        console.log("services/SourceCodeService.js - services:"+JSON.stringify(services));
        /// create the Resource Object "/files/:groupId/:artifactId/:version"
        var fileResource = $resource("/files/:groupId/:artifactId/:version")
        return {
            saveSourceFile: function(groupId, artifactId, version, filename, fileContent){

            }
        }
    }]);