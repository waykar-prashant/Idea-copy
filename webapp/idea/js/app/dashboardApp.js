'use strict';


//-----------[ Create the Application ]--------------//
var dashboardApp = angular.module('dashboardApp', ['ngRoute','dashboardController', 'ui.bootstrap']);

dashboardApp.config(['$routeProvider', function($routeProvider) { $routeProvider.
	when('/', {
		templateUrl: 'partials/dashboard.html',
		controller: 'dashboardCtrl'
	})
}]);

