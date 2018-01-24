/**
 * Module principal et routes de l'application
 */

// Déclaration du module
angular.module('app', ['ngRoute', 'users', 'products', 'orders']);

angular.module('app').config(function($routeProvider){
	$routeProvider.when('/connection', {	// Route pour la page de connexion
		templateUrl : './partial/connexion.html',	// Template
		controller : 'UsersConnectionCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Connexion'}} // Titre de la page
		}
	})
	.when('/accueil', {
		templateUrl : './partial/tpl-catalogue.html',	// Template
		controller : 'listProductController',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Accueil'}} // Titre de la page
		}
	}).when('/catalogue', {	// Route pour la page de catalogue
		templateUrl : './partial/tpl-catalogue.html',	// Template
		controller : 'listProductController',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Catalogue'}} // Titre de la page
		}
	}).when('/catalogue/:id', {	// Route pour la page de detail d'un produit
		templateUrl : './partial/tpl-details-product.html',	// Template
		controller : 'productController',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Produit'}} // Titre de la page
		}
	})
	.when('/panier', {
		templateUrl : './partial/tpl-basket.html',	// Template
		controller : 'OrdersBasketCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Panier'}} // Titre de la page
		}
	});
	$routeProvider.otherwise({	// Route par défaut
		redirectTo : '/accueil'
	});
});
/*
 * Déclaration des routes
 */
/*
angular.module('app').config(function ($routeProvider) {
	$routeProvider.when('/accueil', {	// Route pour la page d'accueil
		templateUrl : './partial/accueil.html',	// Template
		controller : 'XXX',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Accueil'}} // Titre de la page
		}
	}).when('/XXX', {	// Méthode à suivre pour faire une route
		templateUrl : './partial/XXX.html',	// Template
		controller : 'XXX',	// Controller
		resolve : {
			titre: function(){return {libelle : 'XXX'}} // Titre de la page
		}
	});
	$routeProvider.otherwise({	// Route par défaut
		redirectTo : '/accueil'
	});
});*/