var services = angular.module('myApp.services', ['ngResource']);

var baseUrl = 'http://localhost:8080';

services.factory('CustomersFactory', function($resource) {
	return $resource(baseUrl + '/customer', {}, {
		query: {method: 'GET', isArray: true},
		create: {method: 'POST'}
  	})
});

services.factory('CustomerFactory', function ($resource) {
    return $resource(baseUrl + '/customer/:id', {}, {
    	show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@id'} },
        delete: {method: 'DELETE', params: {id: '@id'} }
    })
});

services.factory('ViewsFactory', function($resource) {
	return $resource(baseUrl + '/statusJson', {}, {
		query: {method: 'GET', isArray: true}
	})
});