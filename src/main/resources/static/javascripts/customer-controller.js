var app = angular.module('myApp.controllers', []);

app.controller('CustomerListCtrl', ['$scope', 'CustomersFactory', 'CustomerFactory', '$location',
  function ($scope, CustomersFactory, CustomerFactory, $location) {

	$scope.customers = CustomersFactory.query();
	
    $scope.editCustomer = function (customerId) {
      $location.path('/customer/' + customerId);
    };

    $scope.deleteCustomer = function (customerId) {
      CustomerFactory.delete({ id: customerId },function() {
    	  $scope.customers = CustomersFactory.query();
	    });
    };
	
}]);

app.controller('CustomerCreationCtrl', ['$scope', 'ViewsFactory','CustomersFactory', 'CustomerFactory', '$location',
	function ($scope, ViewsFactory, CustomersFactory, CustomerFactory, $location) {
	
	$scope.statuses = ViewsFactory.query();
	
	$scope.createNewCustomer = function () {
    	console.log($scope.customer);
		CustomersFactory.create($scope.customer);
		$location.path('/search');
	};
}]);

app.controller('CustomerDetailCtrl', ['$scope', '$routeParams', 'ViewsFactory', 'CustomerFactory', '$location',
	function ($scope, $routeParams, ViewsFactory, CustomerFactory, $location) {
	
	$scope.statuses = ViewsFactory.query();
	CustomerFactory.show({id: $routeParams.id}, function(data){
		 $scope.customer = data;
	});
	
    $scope.updateCustomer = function (customerId) {
    	CustomerFactory.update($scope.customer);
    	$location.path('/search');
    };
}]);
