angular.module('products').controller('EditProductCtrl', ['$scope', '$routeParams', 'ProductService', function($scope, $routeParams, ProductService){
	
	$scope.product = undefined;
	var id = $routeParams.id;
	
	ProductService.getOne(id).then(function(data){
		$scope.product = data;
	});

	$scope.edit = function(){
		ProductService.editOne($scope.product).then(function(data){
			$scope.product = data;
		});
	};
	
}]);