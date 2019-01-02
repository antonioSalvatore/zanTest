(function(){
  angular.module('letsJam')
  // SignUp controller
  .controller('SignUpCtrl',
      ['$scope', '$http', 'MusicianServiceFactory',
          function($scope, $http, MusicianServiceFactory) {

              $scope.signup = function() {
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

                  $scope.saveMusician(musicianEntity);
                  //$scope.sayHello();

                  /*MusicianServiceFactory.saveMusician(musicianEntity).then(response){
                      if(response.status == 'OK'){
                          console.log("Salvataggio effettuato!");
                      } else {
                          console.log("Salvataggio non andato a buon fine!");
                      }
                  }*/

              };

              $scope.saveMusician = function(musicianEntity){
                    return $http.post("/letsjam/api/musician/signup", musicianEntity).then(function(response){
                        var result = {};
                        if(!(response === '' || response === null || response === 'null' || response === undefined || response === 'undefined')){
                            result.status = response.data.status;
                            result.genericData = response.data.genericData;
                        }
                        return result;
                    })
              };

              //TODO Delete this method, it's test-only purpose
              $scope.sayHello = function(){
                    return $http.get("/letsjam/api/musician/hello/" + "Peppe").then(function(response){
                        console.log(response);
                        return response;
                    })
              };
  }]);
}());


