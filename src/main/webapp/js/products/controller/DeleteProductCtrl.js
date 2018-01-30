angular.module('products').controller('DeleteProductCtrl', ['$scope','$rootScope','$routeParams', 'productSrv', 'titre', function($scope, $rootScope, $routeParams, productSrv, titre){
	
	$rootScope.titre = titre.libelle;
	$scope.product = undefined;
	var id = $routeParams.id;
	
	productSrv.getOne(id).then(function(data){
		$scope.product = data;
		console.log($scope.product);
	});
	
	$scope.remove =function(){
		if($scope.product.quantities.length < 1){
			productSrv.remove($scope.product.id).then(function(){
				console.log("DeleteProductCtrl: le produit a ete supprime")
			}, function(){
				console.log("DeleteProductCtrl: le produit n'a pas ete supprime");
			});
		}else{
			console.log("DeleteProductCtrl: le produit n'a pas ete supprime car present dans une commande");
		}
	}

}]);