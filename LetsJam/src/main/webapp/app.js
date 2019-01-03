(function(){
  angular.module('letsJam', [
  'ngRoute'
  ])
  .config(['$routeProvider', function($routeProvider) {
      // Set default view of our app to SignUp
      $routeProvider.when('/signup', {
              templateUrl: 'core/signup/signup.html',
              controller: 'SignUpCtrl'
          }).when('/searchMusicians', {
              templateUrl: 'core/searchMusicians/searchMusicians.html',
              controller: 'SignUpCtrl'
          }).otherwise({
              redirectTo: '/signup'
          });
     }])
  ;
}());

