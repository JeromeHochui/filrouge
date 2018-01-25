angular.module('products').controller('SearchProductsCtrl', ['$scope', '$routeParams', 'productSrv', 'titre', function($scope, $routeParams, productSrv, titre){
	
	$scope.searchProduct = [];
	var name = $routeParams.name;	
	
	productSrv.searchByName(name).then(function(data){
		$scope.searchProduct = data;
		
		
	});
	
	
	
}]);