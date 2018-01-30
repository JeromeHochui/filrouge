/**
 * 
 */
angular.module('orders').controller('HistoOrdersCtrl',
		['$scope', '$rootScope', '$location', 'titre', 'histoOrdersSrv', 'ordersBasketSrv', function($scope, $rootScope, $location, titre, histoOrdersSrv, ordersBasketSrv){
		
		$rootScope.titre = titre.libelle;
		histoOrdersSrv.getCommandByUser($rootScope.user.id).then(function(response){
			$scope.orders = response;
			console.log('scope.orders',$scope.orders);
		});
}]);