/**
 * 
 */
angular.module('users').component('connectForm', {
	templateUrl: './partial/tpl-connexion.html',
	controller: ['$rootScope', 'connectionSrv', function($rootScope, connectionSrv){
		
		this.connect = function(user){
			connectionSrv.connect(user.email, user.password);
			
			console.log('connect', user);
			
			connectionSrv.getUser().then(function (response) {
				console.log('response : ', response);
				$rootScope.user = response.data;
				console.log('utilisateur : ', $rootScope.user);
			});
		}
	}],
	bindings: {
		user: "="
	}	
});