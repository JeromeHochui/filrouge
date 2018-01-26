/**
 * Service pour la connexion des utilisateurs
 */

angular.module('orders').factory('ordersBasketSrv', 
			['$http', '$q', '$cookies', function ($http, $q, $cookies) {
				
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
	
	 function updateBasketCookies() {
		var basketsCookie = {};
		console.log('avant forEach', basket);
		angular.forEach(basket, function(item, key) {
			basketsCookie[key] = item;
			console.log('key:', key, ' : ', item);
		});
		$cookies.putObject('basket', basketsCookie);
		console.log('updateCookie', basketsCookie);
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
				updateBasketCookies();
			}
		},
		
		// Fonction pour retourner la liste des produits à afficher dans le panier
		// Toujours sous la forme product/quantity
		getBasket : function () {
			var basketsCookie;
			if(basket.length !== undefined) {
				basketsCookie = $cookies.getObject('basket');
				console.log('basketsCookie', basketsCookie);
				if(basketsCookie) {
					angular.forEach(basketsCookie, function(item, key) {
						basket[key] = item;
						console.log('key:', key, ' : ', item);
					})
				}
			}
			return basket;
		},
		
		// Fonction pour supprimer un produit du panier
		removeFromBasket : function(productId){
			angular.forEach(basket, function(value, key){
				if(value.product.id == productId){
					//Avec splice() on peut enlever à l'index/index+1 un item de la liste
					basket.splice(key, 1);
				}
			});
			updateBasketCookies();
			return basket;
		},
		
		emptyBasket : function () {
			basket = [];
			$cookies.remove('basket');
		}
		
	}
}]);