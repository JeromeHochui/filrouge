angular.module('products').controller('ActivateProductCtrl', ['$scope', '$rootScope', '$routeParams', 'productSrv', 'titre', function($scope, $rootScope, $routeParams, productSrv, titre){
	
	$rootScope.titre = titre.libelle;
	$scope.product = undefined;
	
	$scope.activate = function(){
		productSrv.activate().then(function(data){
			$scope.activate = data;
			console.log("test");
		
		})
		
	}
	
	
}]);