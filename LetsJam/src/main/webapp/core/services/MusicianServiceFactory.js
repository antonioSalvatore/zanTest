(function(){
    angular.module('letsJam')
        .factory('MusicianServiceFactory',
            ['$http',
                function($http){

                    function saveMusician(musicianEntity){
                        return $http.post("/letsjam/api/musician/signup", musicianEntity).then(function(response){
                            var result = {};
                            if(!(response === '' || response === null || response === 'null' || response === undefined || response === 'undefined')){
                                result.status = response.data.status;
                                result.genericData = response.data.genericData;
                            }
                            return result;
                        })
                    };

                    function searchMusicians(filterObject){
                        return $http.post("/letsjam/api/musician/search", filterObject).then(function(response){
                            var result = {};
                            if(!(response === '' || response === null || response === 'null' || response === undefined || response === 'undefined')){
                                result.status = response.data.status;
                                result.genericData = response.data.genericData;
                            }
                            return result;
                        })
                    };

                return {
                    saveMusician : saveMusician ,
                    searchMusicians : searchMusicians
                }

        }]);
}());

