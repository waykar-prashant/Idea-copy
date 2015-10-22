(function(window, undefined) {'use strict';


var mod=angular.module('adf.widget.thermostat', ['adf.provider']);

mod.config(["dashboardProvider", function(dashboardProvider){
        // template object for github widgets
        var widget = {
                templateUrl: '{widgetsPath}/thermostat/src/view.html',
                reload: true,
                resolve: {
                        /* @ngInject */
                        commits: ["thermostatService", "config", function(thermostatService, config){
                                if (config.device){
                                        return thermostatService.getCommits(config.device);
                                }
                        }]
                },
                edit: { templateUrl: '{widgetsPath}/thermostat/src/edit.html' }
        };

        // register github template by extending the template object
        dashboardProvider.widget('thermostat', angular.extend({
		title: 'Temperature and Time Running'
		, description: 'Tells the temperature and time running for 24 hrs as measured by a thermostat'
                , controller: 'thermostatCtrl'
        }, widget));


}]);



angular.module("adf.widget.thermostat").run(["$templateCache", function($templateCache) {$templateCache.put("{widgetsPath}/thermostat/src/edit.html","<form role=form><div class=form-group><label for=device_name>Device Name</label> <input type=text class=form-control id=device_name ng-model=config.device_name placeholder=\"Enter Device Name\"></div></form>");
$templateCache.put("{widgetsPath}/thermostat/src/view.html","<div><h5>{{config.device_name}}</h5><p>Content of {{config.device_name}}</p></div>");}]);
/*
 * The MIT License
 *
 * Copyright (c) 2015, Sebastian Sdorra
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */



var mod = angular.module('adf.widget.thermostat');


mod.controller('thermostatCtrl', ["$scope", "config", function($scope, config){
	//config.device_name='Upstairs';
	console.log('Starting controller:'+JSON.stringify(config));
}]);

/*
 * The MIT License
 *
 * Copyright (c) 2015, Sebastian Sdorra
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */



mod=angular.module('adf.widget.thermostat');

mod.service('thermostatService', ["$q", "$http", function($q, $http){
	return {
		getCommits: function(path){
			var deferred = $q.defer();
			var url = githubApiUrl + path + '/commits?callback=JSON_CALLBACK';
			var request = $http.jsonp(url);

			request.success(function(data){
				if (data && data.meta){
					var status = data.meta.status;
					if ( status < 300 ){
						deferred.resolve(data.data);
					}
					else {
						deferred.reject(data.data.message);
					}
				}
			});

			request.error(function(){
				deferred.reject();
			});

			return deferred.promise;
		}
	};
}]);
})(window);