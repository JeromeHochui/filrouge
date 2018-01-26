angular.module('users').controller('UsersEditCtrl',	['$scope','usersEditSrv', 'connectionSrv','$rootScope','$location', function($scope, usersEditSrv, connectionSrv, $rootScope, $location){
	
	
	connectionSrv.getUser().then(function (response) {
		
		$rootScope.user = response.data;
		$rootScope.user.birthdate = new Date($rootScope.user.birthdate);
		
	});
	
	$scope.editUser = function(){		
		
 		usersEditSrv.edit($scope.user).then(function(userEdit){
 			$scope.product = userEdit;
 			$scope.message = true;
 			
 			
 		});
	};
}]);



