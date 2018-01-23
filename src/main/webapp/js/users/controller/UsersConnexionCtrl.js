/**
 * 
 */

angular.module('').controller('Ctrl', 
			['$scope', '$rootScope', 'titre', '$location', 'adherentsSrv', 'adherentActionSrv', '$routeParams',
	function ($scope,   $rootScope,   titre,   $location,   adherentsSrv,   adherentActionSrv,   $routeParams) {
	
	$rootScope.titre = titre.libelle;
	
	$scope.addAdh = function (adh) {
		console.log('adh', adh);
		adherentActionSrv.addAdh(adh);
		adherentsSrv.noMoreLoaded();
		$location.url('#!/adh-stats');
	}
	
	
	
	
}]);