/**
 * Service pour la connexion des utilisateurs
 */

angular.module('orders').factory('ordersBasketSrv', 
			['$http', '$q', function ($http, $q) {
				
	var basket = [];
	// contient une liste de : {quantity, product}
	
	
	
	return {
		
		addToBasket : function(product, quantity){
			
		},
		
		getBasket : function () {
			return basket;
		}
	}
}]);