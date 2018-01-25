angular.module('products').controller('EditProductCtrl', ['$scope', '$routeParams', 'productSrv', '$location','titre', function($scope, $routeParams, productSrv, $location, titre){
	
	$scope.product = undefined;
	var id = $routeParams.id;
	console.log(id);
	
	
	productSrv.getOne(id).then(function(data){
		$scope.product = data;
		console.log($scope.product);
		
		
	});

	$scope.edit =function(){
		productSrv.edit($scope.product).then(function(dataEdit){	
			
			$scope.product = dataEdit;
			console.log('Editproduct ctrl '+$scope.product);
			$location.path('/catalogue/'+id);
			console.log($scope.product);
			
		});
	}
	}]);