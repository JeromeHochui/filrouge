/**
 * 
 */
angular.module('users').controller('UsersConnectionCtrl',
		['$scope', '$rootScope', '$location', 'titre', 'connectionSrv', function($scope, $rootScope, $location, titre, connectionSrv){
	$rootScope.titre = titre.libelle;
	
	$scope.connect = function(user){
		connectionSrv.connect(user.email, user.password);
	};
}]);