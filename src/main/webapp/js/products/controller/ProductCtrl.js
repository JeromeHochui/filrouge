angular.module('products').controller('ProductCtrl', ['$scope', '$rootScope', '$routeParams','productSrv', function($scope,  $rootScope, $routeParams, productSrv){
	$rootScope.titre = titre.libelle;
	$scope.product = undefined;
	var id = $routeParams.id;
	
	productSrv.getOne(id).then(function(data){
		$scope.product = data;
		console.log($scope.product);
	});
}]);