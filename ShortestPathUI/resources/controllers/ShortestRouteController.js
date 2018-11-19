app.controller("ShortestRouteController", function($scope,$ngBootbox,$http,$window,$location,$rootScope) {
	 
	var config = { headers : {  'Content-Type': 'application/json ;charset=utf-8;'   } }
	  $scope.cal= function(){
		  
		  $http.post("http://localhost:8085/v1/distance",$scope.distance)
          .success(function (response){    
        	  $scope.output=response.output;
          })
          .error(function (response){
          });
		  

      };
});

