angular.module('products').controller('SearchProductsCtrl', ['$scope', '$routeParams', 'productSrv', function($scope, $routeParams, productSrv){
	
	$scope.searchProduct = [];
	var name = $routeParams.name;
	
	productSrv.searchByName(name).then(function(data){
		$scope.searchProduct = data;
		
	});
}]);