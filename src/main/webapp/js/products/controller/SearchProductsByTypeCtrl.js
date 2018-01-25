angular.module('products').controller('SearchProductsByTypeCtrl', ['$scope', '$routeParams', 'productSrv', function($scope, $routeParams, productSrv){

	$scope.searchProductByType = [];
	var type = $routeParams.type;
	
	productSrv.searchByType(type).then(function(data){
		$scope.searchProductByType = data;
		
		
	});

}]);