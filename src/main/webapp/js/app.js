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
		templateUrl : './partial/accueil.html',	// Template
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
	}).when('/inscription', {	// Route pour la page de creation de compte
		templateUrl : './partial/tpl-creation-compte.html',	// Template
		controller : 'UsersCreationCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Creation'}} // Titre de la page
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
	.when('/order/:id', {	// Route pour le detail d'une commande
		templateUrl : './partial/tpl-details-commande.html',	// Template
		controller : 'OrdersCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Detail de commande'}} // Titre de la page
		}
	})
	.when('/search/:name', {	// Route pour la recherche (pour le moment que par nom)
		templateUrl : './partial/tpl-search.html',	// Template
		controller : 'SearchProductsCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Recherche'}} // Titre de la page
		}
	}).when('/type/:type', {	// Route pour la recherche par type
		templateUrl : './partial/tpl-search-type.html',	// Template
		controller : 'SearchProductsByTypeCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Recherche'}} // Titre de la page
		}
	}).when('/creationproduit', {	// Route pour la page de creation de compte
		templateUrl : './partial/tpl-create-product.html',	// Template
		controller : 'CreateProductCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Créer un produit'}} // Titre de la page
		}
	}).when('/edit/:id', {	// Route pour l'édition d'un produit
		templateUrl : './partial/tpl-edit-product.html',	// Template
		controller : 'EditProductCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Edition'}} // Titre de la page
		}
	}).when('/delete/:id', {	// Route pour la suppression d'un produit
		templateUrl : './partial/tpl-delete-product.html',	// Template
		controller : 'DeleteProductCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Suppression'}} // Titre de la page
		}
	}).when('/activate/:id', {	// Route pour l'activation/désactivation
		templateUrl : './partial/tpl-activate-product.html',	// Template
		controller : 'ActivateProductCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Activer/désactiver'}} // Titre de la page
		}
	}).when('/historique', {	// Route pour l'historique des commandes
		templateUrl : './partial/tpl-histo-command.html',	// Template
		controller : 'HistoOrdersCtrl',	// Controller
		resolve : {
			titre: function(){return {libelle : 'Historique'}} // Titre de la page
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