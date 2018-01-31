angular.module('users').controller('UsersEditCtrl',	['$scope','usersEditSrv', 'connectionSrv','$rootScope','$location', function($scope, usersEditSrv, connectionSrv, $rootScope, $location){
	
	
	connectionSrv.getUser().then(function (response) {
		
		$rootScope.user = response.data;
		$rootScope.user.birthdate = new Date($rootScope.user.birthdate);
		
	});
	
	$scope.editUser = function(){		
		
 		usersEditSrv.edit($rootScope.user).then(function(userEdit){
 			$rootScope.user = userEdit;
 			$scope.message = true;
 			
 			
 		});
	};
}]);



