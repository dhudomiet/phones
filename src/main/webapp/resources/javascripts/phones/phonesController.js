phones.controller("PhonesController",function($scope,$http,RestService){
  $scope.phones = {};
  $scope.phones.name = "Henia";
  $scope.disabled = false;
  $scope.us = {}
  $scope.firstname = false;
  $scope.lastname = false;
  $scope.number = false;
  $scope.fullName = function(){
    return $scope.us.firstName+" "+$scope.us.lastName+" "+$scope.us.phone;
  }
  
//  $http.get("/phones/home").success(function(response){
//	 $scope.users = response;
//	 if(response !=null){
//		 console.log($scope.users);
//	 }
//  });
  RestService.getUsers.then(function(resp){
	  $scope.users = resp;
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
  
  var validate = function(firstname,lastname,number){
	  var patFstName = /^([a-z A-Z]{1,20})$/g.exec(firstname);
	  var patLstName = /^([a-z A-Z]{1,40})$/g.exec(lastname);
	  var patNum = /^([\d]{9,12})$/g.exec(number);
	  if(patFstName != null){
		  $scope.firstname = false;
		  if(patLstName != null){
			  $scope.lastname = false;
			  if(patNum != null){
				$scope.number = false;  
			  }else{
				  $scope.number = true;
			  }
		  }else{
			  $scope.lastname = true;
		  }
	  }else{
		  $scope.firstname = true;
	  }
  }
 
  $scope.addUser = function(firstname,lastname,number){
	  validate(firstname,lastname,number);
  }
});