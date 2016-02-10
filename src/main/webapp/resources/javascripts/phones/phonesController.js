phones.controller("PhonesController",function($scope,$http){
  $scope.phones = {};
  $scope.phones.name = "Henia";
  $scope.disabled = false;
  $scope.us = {}
  $scope.fullName = function(){
    return $scope.us.firstName+" "+$scope.us.lastName+" "+$scope.us.phone;
  }
  
  $http.get("/phones/home").success(function(response){
	 $scope.users = response; 
	 console.log("users: "+users);
  });
//  $scope.users=[{firstName: 'Damian', lastName: 'Hudomięt', phone: '889485244'},
//                {firstName: 'Bartłomiej', lastName: 'Surzyński', phone: '511505798'},
//                {firstName: 'Norbert', lastName: 'Bogusiewicz', phone: '782152743'}]; 
  
  $scope.changeVisible = function(){
    $scope.disabled = !$scope.disabled;
  }
  
  $scope.reset = function(){
    $scope.us.firstName = "";
    $scope.us.lastName = "";
    $scope.us.phone = "";
  }
  
  $scope.search(firstname,lastname,number){
	  
  }
});