/**
 * 
 */
angular.module('users').component('connectForm', {
	templateUrl: './partial/tpl-connexion.html',
	controller: ['$rootScope', '$location', 'connectionSrv', 'ordersBasketSrv' , function($rootScope, $location, connectionSrv, ordersBasketSrv){
		
		this.connect = function(user){
			connectionSrv.connect(user.email, user.password).then(function(response){
				console.log('connect', user);
				
				connectionSrv.getUser().then(function (response) {
					console.log('response : ', response);
					$rootScope.user = response.data;
					console.log('utilisateur : ', $rootScope.user);
				});
				if((ordersBasketSrv.getBasket().length !== undefined) && (ordersBasketSrv.getBasket().length > 0)){
					$location.path('/panier');
				} else {
					$location.path('/accueil');
				}
			});
		}
	}],
	bindings: {
		user: "="
	}	
});