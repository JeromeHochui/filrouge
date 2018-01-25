angular.module('products').controller('ProductCtrl', ['$scope', '$routeParams', 'productSrv', function($scope, $routeParams, productSrv){
	
	$scope.product = undefined;
	var id = $routeParams.id;
	
	productSrv.getOne(id).then(function(data){
		$scope.product = data;
		
	});
}]);