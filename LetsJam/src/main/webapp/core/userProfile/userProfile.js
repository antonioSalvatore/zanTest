(function(){
  angular.module('letsJam')
  // Edit Profile controller
  .controller('EditUserCtrl',
      ['$rootScope', '$scope', '$http', '$location','MusicianServiceFactory',
          function($rootScope, $scope, $http, $location, MusicianServiceFactory) {

              $scope.editProfileForm = {};
              $scope.editProfileForm.name = $rootScope.currentUser[0].name;
              $scope.editProfileForm.surname = $rootScope.currentUser[0].surname;
              $scope.editProfileForm.age = $rootScope.currentUser[0].age;
              $scope.editProfileForm.city = $rootScope.currentUser[0].city;
              $scope.editProfileForm.musicalInstrument = $rootScope.currentUser[0].musicalInstrument;
              $scope.editProfileForm.email = $rootScope.currentUser[0].email;

              $scope.editProfile = function() {
                  $scope.loading = true;
                  $scope.error = false;
                  $scope.alreadyExists = false;
                  console.log("call editProfile()");

                  var form = $scope.editProfileForm;

                  var musicianEntity = {};
                  musicianEntity.id = $rootScope.currentUser[0].id;
                  musicianEntity.name = form.name;
                  musicianEntity.surname = form.surname;
                  musicianEntity.age = form.age;
                  musicianEntity.city = form.city;
                  musicianEntity.musicalInstrument = form.musicalInstrument;
                  musicianEntity.email = form.email;
                  musicianEntity.loginEntity = $rootScope.currentUser[0].loginEntity;

                  MusicianServiceFactory.editProfile(musicianEntity).then(function(response){
                      if(response.status == 'OK'){
                          console.log("Update effettuato!");
                          $rootScope.currentUser = response.genericData;
                          $location.path('/searchMusicians');
                      } else if(response.status == 'KO_ALREADY_EXISTS'){
                          $scope.alreadyExists = true;
                      } else {
                          console.log("Update non andato a buon fine!");
                          $scope.error = true;
                      }

                      $scope.loading = false;
                  })
              }
  }]);
}());


