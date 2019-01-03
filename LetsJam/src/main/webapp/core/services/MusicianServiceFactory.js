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

                    function login(loginTransferObject){
                        return $http.post("/letsjam/api/musician/login", loginTransferObject).then(function(response){
                            var result = {};
                            if(!(response === '' || response === null || response === 'null' || response === undefined || response === 'undefined')){
                                result.status = response.data.status;
                                result.genericData = response.data.genericData;
                            }
                            return result;
                        })
                    };

                    function editProfile(musicianEntity){
                        return $http.post("/letsjam/api/musician/editProfile", musicianEntity).then(function(response){
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
                    searchMusicians : searchMusicians,
                    login : login,
                    editProfile : editProfile
                }

        }]);
}());

