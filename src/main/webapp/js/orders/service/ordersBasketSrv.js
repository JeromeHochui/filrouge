/**
 * Service pour la connexion des utilisateurs
 */

angular.module('orders').factory('ordersBasketSrv', 
			['$http', '$q', function ($http, $q) {
				
	var basket = []; // contient une liste de : {quantity, product}
	function initialise(){
		var produit = { id: 1,
				 productName:'kronembourg',
				 price:15,
				 clVolume: 15,
				 gWeight: 15,
				 alcoholercentage:123,
				 stock:105,
				 container:'Bottle',
				 active:false,
				 description:'une très bonne bière',
				 type:'Brune'};
		var produit2 = { id: 2,
				 productName:'Heineken',
				 price:10,
				 clVolume: 33,
				 gWeight: 33,
				 alcoholercentage:10,
				 stock:52,
				 container:'Bottle',
				 active:false,
				 description:'une très bonne bière',
				 type:'Blanche'};
		var couple = {product: produit, quantity: 2};
		var couple2 = {product: produit2, quantity: 3};
		basket.push(couple);
		basket.push(couple2);
	};
	
	
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
		initialiser : function(){
			initialise();
		},
		
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
		},
		
		removeFromBasket : function(productId){
			angular.forEach(basket, function(value, key){
				if(value.product.id == productId){
					basket.splice(key, key+1);
				}
			});
			return basket;
		}
	}
}]);