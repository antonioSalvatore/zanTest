'use strict';

angular.module('letsJam', [
  'ngRoute',
  'letsJam.signup'
]).
  config(['$routeProvider', function($routeProvider) {
   // Set default view of our app to home
       $routeProvider.otherwise({
           redirectTo: '/core/signup'
       });
  }]);