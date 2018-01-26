/**
 * 
 */
angular.module('users').controller('UsersConnectionCtrl',
		['$scope', '$rootScope', '$location', 'titre', 'connectionSrv', function($scope, $rootScope, $location, titre, connectionSrv){
	$rootScope.titre = titre.libelle;
	
	$scope.connect = function(user){
		connectionSrv.connect(user.email, user.password);
		$location('/');
		
		connectionSrv.getUser().then(function (response) {
			console.log('response : ', response);
			$rootScope.user = response.data;
			console.log('utilisateur : ', $rootScope.user);
		});
	};
	
	
}]);