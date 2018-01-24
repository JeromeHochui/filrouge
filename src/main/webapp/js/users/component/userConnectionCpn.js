/**
 * 
 */
angular.module('users').component('connectForm', {
	templateUrl: './partial/tpl-connexion.html',
	controller: ['ConnectionSrv', function( ConnectionSrv){
		
		this.connect = function(user){
			ConnectionSrv.connect(user.email, user.password);
			console.log('connect', user);
		}
	}],
	bindings: {
		user: "="
	}	
});