var app = angular.module('myApp', []);

app.controller('myCtrl', function ($scope) {
    var url = document.URL;
    if (searchURL("GetAllUserAndFaculty") || searchURL("Login")) {
        $("#faculty").addClass("active");
    }else if (searchURL("GetAllCourse")|| searchURL("GetCourseDetail")) {
        $("#course").addClass("active");
    }else if (searchURL("GetAllCMR") || searchURL("GetCMRDetail") || searchURL("AddCMR")) {
        $("#cmr").addClass("active");
    }else if (searchURL("GetAllUser")) {
        $("#staff").addClass("active");
    }else if (searchURL("StatisticalReport")) {
        $("#report").addClass("active");
    }
    
    function searchURL(link){
        if(url.indexOf(link) > 0){
            return true;
        }else{
            return false;
        }
    }

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

    $scope.addCourse = function () {
        $("#btnSkipAssign").fadeIn("slow");
        $("#btnAssignCourse").fadeIn("slow");
        $("#assignCourseForm").fadeIn("slow");
        $("#btnAddCourse").fadeOut("fast");
        $("#addCourseForm").fadeOut("fast");
        $("#btnCancelAddCourse").fadeOut("fast");
    };

    $scope.skipAddCourse = function () {
        $("#skipCourse").click();
    };

    $scope.assignCourse = function () {
        $("#assignCourse").click();
    };

    $scope.addAccount = function () {
        $("#addAccount").click();
    };

    $scope.approveCmr = function () {
        $("#btnApprove").click();
    };
    
    $scope.createCmr = function (){
        $("#btnCreateCmr").click();
    };

});