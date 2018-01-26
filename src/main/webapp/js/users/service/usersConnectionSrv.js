/**
 * Service pour la connexion des utilisateurs
 */

angular.module('users').factory('connectionSrv', 
			['$http', '$q', function ($http, $q) {

	return {
		connect : function(username, password){
			$http.post('/authenticate', undefined, { params:{ username: username, password: password }})
	            .then(function (response) {
	                console.log('success', response);
	            }, function(reason){
	            	console.log('failure', reason);
	            });
		},
		
		getUser : function () {
			return $http.get('/api/users/connected-user');
		},
		
		logout : function () {
			$http.get('/logout').then(function(response){
				console.log('logout');
			});
		}

	}
}]);