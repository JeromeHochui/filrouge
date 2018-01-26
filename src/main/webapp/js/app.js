/**
 * Module principal et routes de l'application
 */

// Déclaration du module

angular.module('app', ['ngRoute', 'ui.bootstrap', 'ngCookies', 'users', 'products', 'orders']);

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
		controller : 'ListProductsCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Accueil'}} // Titre de la page
		}
	}).when('/catalogue', {	// Route pour la page de catalogue
		templateUrl : './partial/tpl-catalogue.html',	// Template
		controller : 'ListProductsCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Catalogue'}} // Titre de la page
		}
	}).when('/catalogue/:id', {	// Route pour la page de detail d'un produit
		templateUrl : './partial/tpl-details-product.html',	// Template
		controller : 'ProductCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Produit'}} // Titre de la page
		}
	}).when('/creation', {	// Route pour la page de creation de compte
		templateUrl : './partial/tpl-creation-compte.html',	// Template
		controller : 'UsersCreationCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Creation Client'}} // Titre de la page
		}
	}).when('/modificationcompte', {	// Route pour la page de creation de compte
		templateUrl : './partial/tpl-modification-compte.html',	// Template
		controller : 'UsersEditCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Modification du compte'}} // Titre de la page
		}
	})
	.when('/panier', {
		templateUrl : './partial/tpl-basket.html',	// Template
		controller : 'OrdersBasketCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Panier'}} // Titre de la page
		}
	})
	.when('/search/:name', {	// Route pour la recherche (pour le moment que par nom)
		templateUrl : './partial/tpl-search.html',	// Template
		controller : 'SearchProductsCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Recherche'}} // Titre de la page
		}
	
	
	}).when('/type/:type', {	// Route pour la recherche (pour le moment que par nom)
		templateUrl : './partial/tpl-search-type.html',	// Template
		controller : 'SearchProductsByTypeCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Recherche par type'}} // Titre de la page
		}
	
	
	}).when('/edit/:id', {	// Route pour la recherche (pour le moment que par nom)
		templateUrl : './partial/tpl-edit-product.html',	// Template
		controller : 'EditProductCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Editer un produit'}} // Titre de la page
		}
	}).when('/delete/:id', {	// Route pour la suppression d'un produit
		templateUrl : './partial/tpl-delete-product.html',	// Template
		controller : 'DeleteProductCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Suppression de produit'}} // Titre de la page
		}
	}).when('/activate', {	// Route pour la recherche (pour le moment que par nom)
		templateUrl : './partial/tpl-catalogue.html',	// Template
		controller : 'ActivateProductCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Activer/désactiver un produit un produit'}} // Titre de la page
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