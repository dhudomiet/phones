phones.service('RestService', function($http) {
	this.getUsers = $http({
		method : 'GET',
		url : '/phones/home'
	}).then(function successCalback(response) {
		return (response.data);
	}, function errorCalback(response) {
		return (response.data.message);
	});

	this.addUser = function(data) {
		return $http({
			method: 'POST',
			url: '/phones/home',
			headers: 'application/json',
			data: data
		}).then(function successCalback(response) {
			return (response.data);
		}, function errorCalback(response) {
			return (response.data.message);
		});
	}
	
	this.deleteUser = function(idUser,idPhone){
		var data = $.param({idUser: idUser, idPhone: idPhone});
		return $http({
			method: 'DELETE',
			url: '/phones/home?'+data,
			headers: 'application/json'
		}).then(function successCalback(response){
			return (response.data);
		}, function errorCalback(response) {
			return (response.data);
		});
		
	}

});