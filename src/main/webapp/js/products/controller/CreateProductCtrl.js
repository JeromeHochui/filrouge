angular.module('products').controller('CreateProductCtrl', ['$scope','$rootScope', '$routeParams', 'productSrv', '$location','titre', function($scope, $rootScope,$routeParams, productSrv, $location, titre){
	
	$rootScope.titre = titre.libelle;
	$scope.product = undefined;
	
	$scope.create = function(product){
		product.active = false;
		console.log(product)
		productSrv.addOne(product);
		$location.path('/catalogue/'+product.id)
	};
}]);