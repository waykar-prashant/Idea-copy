'use strict';

var mod=angular.module('adf.widget.thermostat', ['adf.provider']);

mod.config(function(dashboardProvider){
        // template object for github widgets
        var widget = {
                templateUrl: '{widgetsPath}/thermostat/src/view.html',
                reload: true,
                resolve: {
                        /* @ngInject */
                        commits: function(thermostatService, config){
                                if (config.device){
                                        return thermostatService.getCommits(config.device);
                                }
                        }
                },
                edit: { templateUrl: '{widgetsPath}/thermostat/src/edit.html' }
        };

        // register github template by extending the template object
        dashboardProvider.widget('thermostat', angular.extend({
		title: 'Temperature and Time Running'
		, description: 'Tells the temperature and time running for 24 hrs as measured by a thermostat'
                , controller: 'thermostatCtrl'
        }, widget));


});


