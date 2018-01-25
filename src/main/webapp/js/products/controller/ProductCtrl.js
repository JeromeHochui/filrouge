
angular.module('products').controller('ProductCtrl', ['$scope', '$rootScope', '$routeParams','productSrv', 'titre', function($scope,  $rootScope, $routeParams, productSrv, titre){
	$rootScope.titre = titre.libelle;
	$scope.product = undefined;
	var id = $routeParams.id;
	
	$scope.mini = false;
	
	productSrv.getOne(id).then(function(data){
		
		$scope.product = data;
		
		console.log('product', $scope.product);
	});
}]);