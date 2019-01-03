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
              controller: 'SearchCtrl'
          }).otherwise({
              redirectTo: '/signup'
          });
     }])
  .controller('IndexCtrl',
        ['$scope', '$location',
            function($scope, $location) {

                $scope.signupClicked = false;
                $scope.searchClicked = false;
                $scope.profileClicked = false;

                $scope.goToSignup = function(){
                    $scope.signupClicked = true;
                    $scope.searchClicked = false;
                    $scope.profileClicked = false;
                    $location.path('/signup');
                }

                $scope.goToSearchMusicians = function(){
                    $scope.signupClicked = false;
                    $scope.searchClicked = true;
                    $scope.profileClicked = false;
                    $location.path('/searchMusicians');
                }
   }]);
}());

