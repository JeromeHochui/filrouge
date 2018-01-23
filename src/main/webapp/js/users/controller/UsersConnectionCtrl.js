/**
 * 
 */
angular.module('users').controller('UsersConnectionCtrl',
		['$scope', '$rootscope', 'titre', function($scope, $rootscope, titre){
	$rootscope.titre = titre.libelle;
}]);