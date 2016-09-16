angular.module('myApp', ['ngRoute','myApp.services','myApp.controllers'])

  .config(function ($routeProvider, $httpProvider) {
	  
  $routeProvider
	  .when('/', {
		  templateUrl: 'views/home.html', 
		  controller: 'CustomerListCtrl'
	  })
	  .when('/search', {
		  templateUrl: 'views/customer_list.html', 
		  controller: 'CustomerListCtrl'
	  })
	  .when('/customer/new', {
		  templateUrl: 'views/customer_creation.html', 
		  controller: 'CustomerCreationCtrl'
	  })
	  .when('/customer/:id', {
		  templateUrl: 'views/customer_detail.html', 
		  controller: 'CustomerDetailCtrl'
	  })
	  .otherwise({
		  redirectTo: '/'
  });

     /* CORS... */
     /* http://stackoverflow.com/questions/17289195/angularjs-post-data-to-external-rest-api */
     //$httpProvider.defaults.useXDomain = true;
     //delete $httpProvider.defaults.headers.common['X-Requested-With'];

 })
  
 .directive('ngReallyClick', [function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            element.bind('click', function() {
                var message = attrs.ngReallyMessage;
                if (message && confirm(message)) {
                    scope.$apply(attrs.ngReallyClick);
                }
            });
        }
    }
}]);