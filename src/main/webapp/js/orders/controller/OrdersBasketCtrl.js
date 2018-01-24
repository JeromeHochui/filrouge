/**
 * 
 */
angular.module('orders').controller('OrdersBasketCtrl',
		['$scope', '$rootScope', '$location', 'titre', 'ordersBasketSrv', function($scope, $rootScope, $location, titre, ConnectionSrv){
	$rootScope.titre = titre.libelle;
	
	$scope.connect = function(user){
		ConnectionSrv.connect(user.email, user.password);
	};
}]);