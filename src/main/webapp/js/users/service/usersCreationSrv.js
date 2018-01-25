/**
 * Service pour la creation des utilisateurs
 */

angular.module('users').service('usersCreationSrv', ['$http', function ($http) {
		
	this.create = function(data){
		var promiseCreate = $http.post('/api/users/create', data)
		return promiseCreate.then(function(response){
			return response.data;
		}, function(){
			return {};
		})
	}
}]);