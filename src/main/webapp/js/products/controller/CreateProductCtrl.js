angular.module('products').controller('CreateProductCtrl', ['$scope', '$routeParams', 'productSrv', '$location','titre', function($scope, $routeParams, productSrv, $location, titre){
	
	$scope.product = undefined;
	
	$scope.create = function(product){
		console.log(product)
		productSrv.addOne(product);
	};
}]);