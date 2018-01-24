/**
 * 
 */
angular.module('orders').controller('OrdersBasketCtrl',
		['$scope', '$rootScope', '$location', 'titre', 'ordersBasketSrv', function($scope, $rootScope, $location, titre, ordersBasketSrv){
	$rootScope.titre = titre.libelle;
	
	
}]);