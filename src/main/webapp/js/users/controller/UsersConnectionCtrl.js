/**
 * 
 */
angular.module('users').controller('UsersConnectionCtrl',
		['$scope', '$rootScope', '$location', 'titre', 'ConnectionSrv', function($scope, $rootScope, $location, titre, ConnectionSrv){
	$rootScope.titre = titre.libelle;
	
	$scope.connect = function(user){
		ConnectionSrv.connect(user.email, user.password);
	};
}]);