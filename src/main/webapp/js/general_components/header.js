/**
 * Le composant correspondant au footer utilisé sur toutes les pages.
 */

angular.module('app').component('myHeader', {
	templateUrl:	'partial/tpl-header.html',
controller: ['ordersBasketSrv', 'connectionSrv', '$rootScope', function( ordersBasketSrv, connectionSrv, $rootScope){
		
		this.logout = function(){
			connectionSrv.logout().then(function (response) {
				$rootScope.user = undefined;
			}, function(reason){
				console.log('error', reason);
			});
		}
	}],
	bindings:		{
		user: "="
	}
});