angular.module('products').controller('ListProductsCtrl', ['$scope', '$routeParams', 'productSrv', function($scope, $routeParams, productSrv){
	
	$scope.list = [];
	
	productSrv.getAll().then(function(list){
		$scope.list = list;
	});
}]);