angular.module('products').controller('ListProductsCtrl', ['$scope', '$rootScope', '$routeParams', 'productSrv', 'titre', function($scope, $rootScope, $routeParams, productSrv, titre){
	
	$rootScope.titre = titre.libelle;
	$scope.list = [];
	
	productSrv.getAll().then(function(list){
		$scope.list = list;
	});
}]);