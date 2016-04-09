var app = angular.module('myApp', []);

app.controller('myCtrl', function ($scope) {

    $scope.showAddCourseForm = function () {
        $("#btnShowAddCourse").fadeOut("fast");
        $("#btnAddCourse").fadeIn("slow");
        $("#btnCancelAddCourse").fadeIn("slow");
        $("#addCourseForm").fadeIn("slow");
    };

    $scope.cancelAddCourse = function () {
        $("#btnShowAddCourse").fadeIn("slow");
        $("#btnAddCourse").fadeOut("fast");
        $("#btnCancelAddCourse").fadeOut("fast");
        $("#addCourseForm").fadeOut("fast");
    };

    $scope.addCourse = function (){
        $("#btnSkipAssign").fadeIn("slow");
        $("#btnAssignCourse").fadeIn("slow");
        $("#assignCourseForm").fadeIn("slow");
        $("#btnAddCourse").fadeOut("fast");
        $("#addCourseForm").fadeOut("fast");
        $("#btnCancelAddCourse").fadeOut("fast");
    };
    
    $scope.skipAddCourse = function (){
        $("#skipCourse").click();
    };
    
    $scope.assignCourse = function(){
        $("#assignCourse").click();
    };
    
    $scope.addAccount = function(){
        $("#addAccount").click();
    }
    
    $scope.approveCmr = function(){
        $("#btnApprove").click();
    }
    
});