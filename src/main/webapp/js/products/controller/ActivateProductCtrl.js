angular.module('products').controller('ActivateProductCtrl', ['$scope', '$rootScope', '$routeParams', 'productSrv', 'titre', function($scope, $rootScope, $routeParams, productSrv, titre){
	
	$rootScope.titre = titre.libelle;
	$scope.product = undefined;
	var id = $routeParams.id
	

	
	
	productSrv.getOne(id).then(function(data){
		$scope.product = data;
		productSrv.activate($scope.product).then(function(){				
			console.log("le produit est activé/désactivé sur"+$scope.product.productName);
			productSrv.getAll().then(function(list){
				$scope.list = list;
			});
		});
		console.log($scope.product);
			
	});
	
	
	
	
}]);


