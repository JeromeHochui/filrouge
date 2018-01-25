angular.module('products').controller('SearchProductsByTypeCtrl', ['$scope', '$routeParams', 'productSrv', 'titre', function($scope, $routeParams, productSrv, titre){

	$scope.searchProductByType = [];
	var type = $routeParams.type;
	
	$scope.mini = true;
	
	productSrv.searchByType(type).then(function(data){
		$scope.searchProductByType = data;
		
		
	});


}]);