(function(){
  angular.module('letsJam')
  // Search controller
  .controller('SearchCtrl',
      ['$scope', '$http', '$location','MusicianServiceFactory',
          function($scope, $http, $location, MusicianServiceFactory) {

              $scope.search = function() {
                  $scope.loading = true;
                  $scope.error = false;
                  $scope.emptyList = false;
                  console.log("call search()");

                  var searchForm = $scope.searchForm;

                  var filterObject = {};
                  filterObject.filterFields = {};

                  if(searchForm){
                      filterObject.filterFields.age = searchForm.age;
                      filterObject.filterFields.city = searchForm.city;
                      filterObject.filterFields.musicalInstrument = searchForm.musicalInstrument;
                  }

                  MusicianServiceFactory.searchMusicians(filterObject).then(function(response){
                      if(response.status == 'OK'){
                          console.log("Ricerca effettuata!");
                          if(response.genericData == null || response.genericData.length == 0){
                              $scope.emptyList = true;
                          } else {
                              $scope.musiciansList = response.genericData;
                          }
                          /*$location.path('/searchMusicians');*/
                      } else {
                          console.log("Ricerca non andata a buon fine!");
                          $scope.error = true;
                      }

                      $scope.loading = false;
                  })
              };
  }]);
}());


