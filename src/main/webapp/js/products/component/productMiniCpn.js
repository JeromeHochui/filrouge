/**
 * 
 */
angular.module('products').component('productMini', {
	templateUrl: './partial/tpl-miniature-produit.html',
	controller: ['ordersBasketSrv', function( ordersBasketSrv){
		
		
	}],
	bindings: {
		product: "="
	}	
});