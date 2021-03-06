angular.module('orders').controller('OrdersCtrl',
		['$scope', '$rootScope', '$routeParams', '$location', '$cookies', 'titre', 'ordersBasketSrv', 'ordersProductsSrv', function($scope, $rootScope, $routeParams, $location, $cookies, titre, ordersBasketSrv, ordersProductsSrv){
		
		$scope.order = undefined;
		$rootScope.titre = titre.libelle;
		var id = $routeParams.id;
		
		ordersProductsSrv.getOrder(id).then(function(data){
			$scope.order = data;

			$scope.totalPrice = 0;
			angular.forEach($scope.order.quantities, function(value, key){
				$scope.totalPrice += (value.quantity * value.products.price);
			});
			
			$scope.totalQuantity = 0;
			angular.forEach($scope.order.quantities, function(value, key){
				$scope.totalQuantity += value.quantity;
			});

		});

}]);