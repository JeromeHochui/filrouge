angular.module('products').controller('listProductController', ['$scope', '$routeParams', 'ProductService', function($scope, $routeParams, ProductService){
	
	$scope.list = [];
	
	ProductService.getAll().then(function(list){
		$scope.list = list;
	});
}]);