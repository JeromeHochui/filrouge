/**
 * 
 */
angular.module('users').controller('UsersConnectionCtrl',
		['$scope', '$rootScope', 'titre', 'connectionSrv', function($scope, $rootScope, titre, connectionSrv){
	$rootScope.titre = titre.libelle;
	
	$scope.connect = function(user){
		connectionSrv.connect(user.email, user.password).then(function(response){
			connectionSrv.getUser().then(function (response) {
				console.log('response : ', response);
				$rootScope.user = response.data;
				console.log('utilisateur : ', $rootScope.user);
			});
		});
		
	};
	
	
}]);