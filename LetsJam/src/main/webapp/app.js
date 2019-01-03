(function(){
  angular.module('letsJam', [
  'ngRoute'
  ])
  .run(function($rootScope) {
      $rootScope.currentUser = {};
  })
  .config(['$routeProvider', function($routeProvider) {
      // Set default view of our app to SignUp
      $routeProvider.when('/signup', {
              templateUrl: 'core/signup/signup.html',
              controller: 'SignUpCtrl'
          }).when('/searchMusicians', {
              templateUrl: 'core/searchMusicians/searchMusicians.html',
              controller: 'SearchCtrl'
          }).when('/login', {
              templateUrl: 'core/signup/login.html',
              controller: 'SignUpCtrl'
          }).when('/editProfile', {
              templateUrl: 'core/userProfile/editProfile.html',
              controller: 'EditUserCtrl'
          }).otherwise({
              redirectTo: '/signup'
          });
     }])
  .controller('IndexCtrl',
        ['$scope', '$rootScope', '$location',
            function($scope, $rootScope, $location) {

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

                $scope.goToEditProfile = function(){
                    $scope.signupClicked = false;
                    $scope.searchClicked = false;
                    $scope.profileClicked = false;
                    $location.path('/editProfile');
                }

                $scope.logout = function (){
                    $rootScope.currentUser = {};
                    $location.path('/signup');
                }
   }]);
}());

