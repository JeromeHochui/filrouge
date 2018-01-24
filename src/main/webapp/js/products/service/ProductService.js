angular.module('products').service("ProductService", ['$http', function($http){
	
	var p = $http.get('/api/product/search')
	
	this.getAll = function(){
		
		var p2 = p.then(function(response){
			 var liste = response.data;
			 return liste;
		});
		return p2;
	};
	
	var ps = {};
	this.getOne = function(id){
		if(!ps[id]){
			ps[id] = $http.get('/api/product/search?id='+id);
		}
		var p2 = ps[id].then(function(response){
			console.log(response.data);
			return response.data[0];
		});
		return p2;
	};
	
	this.addOne = function(data){
		var promiseAdd = $http.post('/api/product/create', data)
		return promiseAdd.then(function(response){
			return response.data;
		}, function(){
			return {};
		})
	}
	
	this.edit = function(data){
		var promiseEdit = $http.post('/api/product/update', data)
		return promiseEdit.then(function(response){
			return response.data;
		}, function(){
			return {};
		})
	}
	
	this.delete = function(data){
		var promiseDelete = $http.post('/api/product/delete', data)
		return promiseDelete.then(function(response){
			return response.data;
		}, function(){
			return {};
		})
	}
}]);
