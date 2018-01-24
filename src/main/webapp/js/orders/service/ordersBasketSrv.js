/**
 * Service pour la connexion des utilisateurs
 */

angular.module('orders').factory('ordersBasketSrv', 
			['$http', '$q', function ($http, $q) {
				
	var basket = []; // contient une liste de : {quantity, product}
	
	/*
	 * Fonction pour valider la quantité d'un produit demandé pour la commande
	 * par rapport à son stock disponible.
	 */
	function verifQuantity(product, quantity) {
		if (quantity !== undefined && quantity > 0) {
			if (quantity > product.stock) {
				quantity = product.stock;
			}
		} else {
			quantity = 1;
		}
		return quantity;
	}
	
	
	return {
		
		addToBasket : function(product, quantity){
			if (product !== undefined) {
				// On met une quantité valide
				quantity = verifQuantity(product, quantity);
				
				// On crée l'objet orderProduct correspondant à l'ajout du produit et de sa quantité pour la commande
				var orderProduct = {};
				orderProduct.quantity = quantity;
				orderProduct.product = product;
				
				// On ajoute le couple produit / quantité à la commande
				basket.push(orderProduct);
			}
		},
		
		getBasket : function () {
			return basket;
		}
	}
}]);