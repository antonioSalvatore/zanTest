'use strict';

angular.module('letsJam.signup', ['ngRoute'])

// Declared route
.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/core/signup', {
        templateUrl: 'core/signup/signup.html',
        controller: 'SignUpCtrl'
    });
}])

// SignUp controller
.controller('SignUpCtrl', [function() {

}]);