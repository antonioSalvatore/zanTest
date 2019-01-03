(function(){
  angular.module('letsJam')
  // SignUp controller
  .controller('SignUpCtrl',
      ['$rootScope', '$scope', '$http', '$location','MusicianServiceFactory',
          function($rootScope, $scope, $http, $location, MusicianServiceFactory) {

              $scope.signup = function() {
                  $scope.loading = true;
                  $scope.error = false;
                  $scope.alreadyExists = false;
                  console.log("call signup()");

                  var form = $scope.form;

                  var loginEntity = {};
                  loginEntity.username = form.username;
                  loginEntity.password = form.password;

                  var musicianEntity = {};
                  musicianEntity.name = form.name;
                  musicianEntity.surname = form.surname;
                  musicianEntity.age = form.age;
                  musicianEntity.city = form.city;
                  musicianEntity.musicalInstrument = form.musicalInstrument;
                  musicianEntity.email = form.email;
                  musicianEntity.loginEntity = loginEntity;

                  MusicianServiceFactory.saveMusician(musicianEntity).then(function(response){
                      if(response.status == 'OK'){
                          console.log("Salvataggio effettuato!");
                          $rootScope.currentUser = response.genericData;
                          $location.path('/searchMusicians');
                      } else if(response.status == 'KO_ALREADY_EXISTS'){
                          $scope.alreadyExists = true;
                      } else {
                          console.log("Salvataggio non andato a buon fine!");
                          $scope.error = true;
                      }

                      $scope.loading = false;
                  })
              }

              $scope.goToLogin = function(){
                  $location.path('/login');
              }

              $scope.goToSignUp = function() {
                  $location.path('/signup');
              }

              $scope.login = function() {
                  $scope.loading = true;
                  $scope.error = false;
                  $scope.userNotPresent = false;
                  console.log("call login()");

                  var form = $scope.loginForm;

                  var loginEntity = {};
                  loginEntity.username = form.username;
                  loginEntity.password = form.password;

                  var loginTransferObject = {};
                  loginTransferObject.genericData = loginEntity;

                  MusicianServiceFactory.login(loginTransferObject).then(function(response){
                      if(response.status == 'OK'){
                          if(response.genericData){
                              console.log("Login effettuato!");
                              $rootScope.currentUser = response.genericData;
                              $location.path('/searchMusicians');
                          } else {
                              console.log("Quest'utenza non esiste!");
                              $scope.userNotPresent = true;
                          }
                      } else {
                          console.log("Login non andato a buon fine!");
                          $scope.error = true;
                      }

                      $scope.loading = false;
                  })
              }
  }]);
}());


