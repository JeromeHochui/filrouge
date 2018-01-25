angular.module('products').controller('searchProductsByTypeCtrl', ['$scope', '$routeParams', 'productSrv', 'titre', function($scope, $routeParams, productSrv, titre){

	$scope.searchProductByType = [];
	var type = $routeParams.type;
	
	productSrv.searchByType(type).then(function(data){
		$scope.searchProductByType = data;
		
		
	});

}]);