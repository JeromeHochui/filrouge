/**
 * 
 */
angular.module('users').component('connectForm', {
	templateUrl: './partial/tpl-connexion.html',
	controller: ['connectionSrv', function( connectionSrv){
		
		this.connect = function(user){
			connectionSrv.connect(user.email, user.password);
			console.log('connect', user);
		}
	}],
	bindings: {
		user: "="
	}	
});