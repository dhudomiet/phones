var phones = angular.module("phones",['ngRoute']);

phones.config(['$routeProvider',function($routeProvider){
	$routeProvider.
	when('/addUser',{
		templateUrl: 'filterForm.html', controller: 'PhonesController'
	}).
	otherwise({
		redirectTo: '/addUser'
	});
	
}]);