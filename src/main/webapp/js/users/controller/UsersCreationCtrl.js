angular.module('users').controller('UsersCreationCtrl',
		['$scope', '$rootScope', '$location', 'titre', 'usersCreationSrv', function($scope, $rootScope, $location, titre, usersCreationSrv){
	$rootScope.titre = titre.libelle;
	$scope.user = undefined;
	
	$scope.create = function(user){
 		usersCreationSrv.create(user);
	};
}]);