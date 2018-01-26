/**
 * 
 */
angular.module('orders').service('ordersProductsSrv', ['$http', function ($http) {
	
	this.create = function(data){
		var promiseCreate = $http.post('/api/orders/create', data)
		return promiseCreate.then(function(response){
			console.log(response.data);
			return response.data;
		}, function(){
			return {};
		})
	}
	
	function createCommand(){
		
	}
}]);