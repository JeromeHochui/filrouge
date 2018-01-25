angular.module('products').controller('EditProductCtrl', ['$scope', '$routeParams', 'productSrv', 'titre', function($scope, $routeParams, productSrv, titre){
	
	$scope.product = undefined;
	var id = $routeParams.id;
	
	productSrv.getOne(id).then(function(data){
		$scope.product = data;
	});

	$scope.edit = function(){
		productSrv.editOne($scope.product).then(function(data){
			$scope.product = data;
		});
	};
	
}]);