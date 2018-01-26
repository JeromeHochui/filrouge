/**
 * Le composant correspondant au bloc pour ajouter un produit au panier.
 */

angular.module('app').component('ajoutPanier', {
	templateUrl:	'partial/tpl-ajout-panier.html',
	controller: ['$location', 'ordersBasketSrv', function( $location, ordersBasketSrv){
		
		this.addToBasket = function(product, quantity){
			ordersBasketSrv.addToBasket(product, quantity);
			console.log('addToBasket', product);
			$location.path('#!/panier');
		}
	}],
	bindings: {
		product: "=",
		quantity: "=",
		mini: "="
	}	
});