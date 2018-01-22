/**
 * Module principal et routes de l'application
 */

// Déclaration du module
angular.module('app', ['ngRoute', 'users', 'products', 'orders']);

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