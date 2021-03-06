angular.module('products').service("productSrv", ['$http', function($http){
	
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
			ps[id] = $http.get('/api/product/search',{params:{id:id}});
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
		var edit = $http.put('/api/product/update', data)
			.then(function(response){
				return response.data;
			}); 
		return edit;
		
	}
	
	this.remove = function(id){
		var promiseDelete = $http.delete('/api/product/delete/'+id)
		return promiseDelete.then(function(response){
			console.log("productSrv: le produit a ete supprime");
		}, function(){
			console.log("productSrv: le produit n'a pas ete supprime");;
		})
	}
	
	this.searchByName = function(name){
		
		var getByName = $http.get('/api/product/search', {params:{productName:name}})
			.then(function(response){
				return response.data;
			});
				return getByName;
			}
	
	this.searchByType = function(type){
		
		return $http.get('api/product/search', {params:{type:type}}).then(function(response){
			return response.data;
		});
	}
	
	this.activate = function(data){
		
		var getActivate = $http.put('api/product/activate', data);
			return getActivate.then(function(response){
				return response.data;
			});
				
		}
}]);



