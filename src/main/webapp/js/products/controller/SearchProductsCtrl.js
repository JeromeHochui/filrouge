angular.module('products').controller('SearchProductsCtrl', ['$scope', '$routeParams', 'ProductService', function($scope, $routeParams, ProductService){
	
	$scope.searchProduct = [];
	var name = $routeParams.name;
	
	ProductService.searchByName(name).then(function(data){
		$scope.searchProduct = data;
		
	});
}]);