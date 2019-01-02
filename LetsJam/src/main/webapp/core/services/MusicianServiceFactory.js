(function(){
    angular.module('letsJam')
        .factory('MusicianServiceFactory',
            ['$http',
                function($http){

                    function saveMusician(musicianEntity){
                        return $http.post("/api/musician/signup", musicianEntity).then(function(response){
                            var result = {};
                            if(!(response === '' || response === null || response === 'null' || response === undefined || response === 'undefined')){
                                result.status = response.status;
                                result.genericData = response.genericData;
                            }
                            return result;
                        })
                    }

                return {
                    saveMusician : saveMusician
                }

        }]);
}());

