angular.module('products').controller('ListProductsCtrl', ['$scope', '$rootScope', '$routeParams', 'productSrv', 'titre', function($scope, $rootScope, $routeParams, productSrv, titre){
	
	$rootScope.titre = titre.libelle;
	$scope.list = [];
	
	$scope.mini = true;
	
	productSrv.getAll().then(function(list){
		$scope.list = list;
	});
}]);