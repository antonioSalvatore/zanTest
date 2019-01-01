angular.module('letsJam', [
'ngRoute',
'letsJam.signup'
])
.config(['$routeProvider', function($routeProvider) {
    // Set default view of our app to home
    $routeProvider.when('/signup', {
            templateUrl: 'core/signup/signup.html',
            controller: 'SignUpCtrl'
        }).otherwise({
            redirectTo: '/signup'
        });
   }])
;