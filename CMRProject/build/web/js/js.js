var app = angular.module('myApp', []);

app.controller('myCtrl', function ($scope) {

    $scope.showAddEventForm = function () {
        $("#btnShowAddCourse").fadeOut("fast");
        $("#btnAddCourse").fadeIn("slow");
        $("#btnCancelAddCourse").fadeIn("slow");
        $("#addCourseForm").fadeIn("slow");
    };

    $scope.cancelAddEvent = function () {
        $("#btnShowAddCourse").fadeIn("slow");
        $("#btnAddCourse").fadeOut("fast");
        $("#btnCancelAddCourse").fadeOut("fast");
        $("#addCourseForm").fadeOut("fast");
    };

    $scope.addEvent = function (){
        $("#btnSkipAssign").fadeIn("slow");
        $("#btnAddCourse").fadeOut("fast");
        $("#addCourseForm").fadeOut("fast");
        $("#btnCancelAddCourse").fadeOut("fast");
        $("#addCourse").click();
    };
    
});