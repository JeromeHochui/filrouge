angular.module('products').controller('productController', ['$scope', '$routeParams', 'ProductService', function($scope, $routeParams, ProductService){
	
	$scope.product = undefined;
	var id = $routeParams.id;
	
	ProductService.getOne(id).then(function(data){
		$scope.product = data;
		console.log($scope.product);
	});
}]);