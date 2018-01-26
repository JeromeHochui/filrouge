/**
 * Le composant correspondant au footer utilisé sur toutes les pages.
 */

angular.module('app').component('myHeader', {
	templateUrl:	'partial/tpl-header.html',
controller: ['ordersBasketSrv', 'connectionSrv', '$rootScope', function( ordersBasketSrv, connectionSrv, $rootScope){
		
		this.logout = function(){
			connectionSrv.logout().then(function () {
				connectionSrv.getUser().then(function (response) {
					console.log('user deco', response);
				}, function (reason) {
					console.log('erreur', reason);
				});
			});
			$rootScope.user = undefined;
		}
	}],
	bindings:		{
		user: "="
	}
});