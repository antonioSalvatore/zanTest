(function(){
  angular.module('letsJam')
  // SignUp controller
  .controller('SignUpCtrl',
      ['$scope', '$http', '$location','MusicianServiceFactory',
          function($scope, $http, $location, MusicianServiceFactory) {

              $scope.signup = function() {
                  $scope.loading = true;
                  $scope.error = false;
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
                          $location.path('/searchMusicians');
                      } else {
                          console.log("Salvataggio non andato a buon fine!");
                          $scope.error = true;
                      }

                      $scope.loading = false;
                  })
              }
  }]);
}());


