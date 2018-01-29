/**
 * 
 */
angular.module('orders').factory('ordersProductsSrv', ['$rootScope', '$http', '$cookies', 'dateFilter', function ($rootScope, $http, $cookies, dateFilter) {
	
	var ordersProducts = [];
	
	function createReference(){
		var id = $rootScope.user.id;
		var date = new Date();
		return (""+id+"-"+dateFilter(date, 'yyyyMMdd')); // 14-20180129 par exemple
	}
	
	return {

		createOrders : function(user){
			var reference = createReference();
			var dateCommand = dateFilter(new Date(), 'yyyy-MM-dd');
			
		},
		
		createOrdersProducts : function(orderProductList){
			
		}
	}
}]);