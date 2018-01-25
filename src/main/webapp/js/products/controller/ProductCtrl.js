angular.module('products').controller('ProductCtrl', ['$scope','$rootScope','$routeParams', 'productSrv', 'titre', function($scope, $rootScope, $routeParams, productSrv, titre){
	$rootScope.titre = titre.libelle;
	$scope.product = undefined;
	var id = $routeParams.id;
	
	productSrv.getOne(id).then(function(data){
		$scope.product = data;
		
	});

}]);