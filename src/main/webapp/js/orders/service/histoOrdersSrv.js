/**
 * 
 */
angular.module('orders').factory('histoOrdersSrv', ['$rootScope', '$http', function ($rootScope, $http) {
	var histoCommand = [];
	
	function calculQuantityTotal(id){
		var basket;
		console.log('id', id);
		return $http.get('/api/order-product/by-order/'+id).then(function(response){
			console.log('calculQuantityTotal response', response);
			basket = response.data;
			var totalQuantity = 0;
			console.log('calculQuantityTotal basket', basket);
			angular.forEach(basket, function(value, key){
				totalQuantity += value.quantity;
			})
			return totalQuantity;
		});
	}
	
	return {
		getCommandByUser : function(id) {
			
			return $http.get('api/orders/by-user/'+id).then(function(response){
				console.log('by-user', response.data);
				
				
				angular.forEach(response.data, function(value, key){
					calculQuantityTotal(value.id).then(function(data){
						console.log('data', data);
						value.totalQuantity = data;
					});
					
				})
				return response.data;
			})
		}
	}
}]);