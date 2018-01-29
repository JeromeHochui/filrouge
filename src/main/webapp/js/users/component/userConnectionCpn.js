/**
 * 
 */
angular.module('users').component('connectForm', {
	templateUrl: './partial/tpl-connexion.html',
	controller: ['$rootScope', '$location', 'connectionSrv', function($rootScope, $location, connectionSrv){
		
		this.connect = function(user){
			connectionSrv.connect(user.email, user.password).then(function(response){
				console.log('connect', user);
				
				connectionSrv.getUser().then(function (response) {
					console.log('response : ', response);
					$rootScope.user = response.data;
					console.log('utilisateur : ', $rootScope.user);
				});
				$location.path('/accueil');
			});
			
			
		}
	}],
	bindings: {
		user: "="
	}	
});