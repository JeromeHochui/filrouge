angular.module('products').controller('ListProductsCtrl', ['$scope', '$rootScope', '$routeParams', 'productSrv', function($scope, $rootScope, $routeParams, productSrv){
	$rootScope.titre = titre.libelle;
	$scope.list = [];
	
	productSrv.getAll().then(function(list){
		$scope.list = list;
	});
}]);