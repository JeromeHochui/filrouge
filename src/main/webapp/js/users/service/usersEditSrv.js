angular.module('users').service('usersEditSrv', ['$http', function ($http) {
		
	this.edit = function(data){
		var promiseEdit = $http.put('/api/users/update', data)
		return promiseEdit.then(function(response){
			return response.data;
		})	
	}
	
	
		
}]);


