/**
 * 
 */
angular.module('orders').factory('ordersProductsSrv', ['$rootScope', '$http', 'dateFilter', 'productSrv', function ($rootScope, $http, dateFilter, productSrv) {
	
	var ordersProducts = [];
	
	function refCreator(){
		var id = $rootScope.user.id;
		var date = new Date();
		var alea = Math.floor(Math.random() * (9999 - 1000) + 1000);
		return (alea+"-"+id+"-"+dateFilter(date, 'yyyyMMdd')); // 14-20180129 par exemple
	}
	
	function calculPrixTotal(basket){
		var totalPrice = 0;
		angular.forEach(basket, function(value, key){
			totalPrice += (value.quantity * value.products.price);
		})
		return totalPrice;
	}
	
	function createOrdersProducts (orderProductList, order){
		angular.forEach(orderProductList, function(value, key){
			value.orders = order;
			var p = value.products;
			if(p.stock > value.quantity){
				p.stock = p.stock - value.quantity;
			} else {
				value.quantity = p.stock;
				p.stock = 0;
			}
			$http.post('/api/order-product/create', value).then(function(response){
				console.log('Success', response);
				$http.put('/api/product/update', p).then(function(response){
					console.log('response', response);
				})
			},function(reason){
				console.log('Error', reason);
			});
		});
	}
	
	return {

		createOrder : function(user, basket){
			var ref = refCreator();
			var dateCommand = dateFilter(new Date(), 'yyyy-MM-dd');
			var prixTotal = calculPrixTotal(basket);
			var order = {
					reference: ref,
					commandDate: dateCommand,
					users: user,
					total: prixTotal
					};
			
			$http.post('/api/orders/create', order).then(function (response) {
				createOrdersProducts(basket, response.data);
			}, function (reason) {
				console.log('Error', reason);
			});
		},
		
		getOrder : function (id) {
			var ps = {};
			if(!ps[id]){
				ps[id] = $http.get('/api/orders/'+id);
			}
			var p2 = ps[id].then(function(response){
				return response.data;
			});
			return p2;
		},
		
		createReference : function () {
			return refCreator();
		}
		
		
	}
}]);