/**
 * 
 */
angular.module('products').component('productMini', {
	templateUrl: './partial/tpl-miniature-produit.html',
	controller: ['ordersBasketSrv', function( ordersBasketSrv){
		
		this.addToBasket = function(product, quantity){
			ordersBasketSrv.addToBasket(product, quantity);
			console.log('addToBasket', product);
		}
	}],
	bindings: {
		product: "=",
		quantity: "=",
		mini: "="
	}	
});