/**
 * 
 */
angular.module('orders').controller('OrdersBasketCtrl',
		['$scope', '$rootScope', '$location', 'titre', 'ordersBasketSrv', function($scope, $rootScope, $location, titre, ordersBasketSrv){
	
	$scope.basket = [];
	$rootScope.titre = titre.libelle;
	$scope.basket = ordersBasketSrv.getBasket();
	
	function calculPrixTotal(){
		$scope.totalPrice = 0;
		angular.forEach($scope.basket, function(value, key){
			$scope.totalPrice += value.quantity;
		})
	}
	calculPrixTotal();
}]);