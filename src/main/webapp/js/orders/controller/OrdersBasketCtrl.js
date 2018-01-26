/**
 * 
 */
angular.module('orders').controller('OrdersBasketCtrl',
		['$scope', '$rootScope', '$location', '$cookies', 'titre', 'ordersBasketSrv', function($scope, $rootScope, $location, $cookies, titre, ordersBasketSrv){
	
	$scope.basket = [];
	$rootScope.titre = titre.libelle;
	$scope.basket = ordersBasketSrv.getBasket();
	
	function calculPrixTotal(){
		$scope.totalPrice = 0;
		angular.forEach($scope.basket, function(value, key){
			$scope.totalPrice += (value.quantity * value.product.price);
		})
	}
	calculPrixTotal();
	
	function calculQuantityTotal(){
		$scope.totalQuantity = 0;
		angular.forEach($scope.basket, function(value, key){
			$scope.totalQuantity += value.quantity;
		})
	}
	calculQuantityTotal();
	
	$scope.removeFromBasket = function(productId){
		$scope.basket = ordersBasketSrv.removeFromBasket(productId);
		calculPrixTotal();
		calculQuantityTotal();
	}
}]);