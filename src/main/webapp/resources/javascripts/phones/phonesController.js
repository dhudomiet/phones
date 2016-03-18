phones.controller("PhonesController",function($scope,$http,RestService){
  $scope.phones = {};
  $scope.phones.name = "Henia";
  $scope.disabled = false;
  $scope.us = {}
  $scope.firstname = false;
  $scope.lastname = false;
  $scope.number = false;
  $scope.itemsPerPage = 10;
  $scope.currentPage = 0;

  $scope.updateData = function() {
	  RestService.getUsers.then(function(resp){
		  $scope.users=resp;
	});
  }
  
  $scope.updateData();
  
  $scope.prevPage = function(){
	  if($scope.currentPage >0){
		  $scope.currentPage--;
	  }
  }
  
  $scope.prevPageDisabled = function(){
	  return ($scope.currentPage == 0) ? "disabled" : "";		  
  }
  
  $scope.pageCount = function(){
	  if($scope.users.length<$scope.itemsPerPage){
		  return 0;
	  }
	  else {
		  return Math.ceil($scope.users.length/$scope.itemsPerPage);
	  }	 
  }
  
  $scope.nextPage = function(){
	  if($scope.currentPage < $scope.pageCount()){
		  $scope.currentPage++;
	  }
  }
  
  $scope.nextPageDisabled = function(){
	  return ($scope.currnetPage == $scope.pageCount())? "disabled" : "";
  }
  
  $scope.setPage = function(page){
	  $scope.currentPage = page;
  }
  
  
 
//  RestService.getUsers.then(function(resp){
//	  $scope.users = resp;
//  });
//  $http.get("/phones/home").success(function(response){
//	 $scope.users = response;
//	 if(response !=null){
//		 console.log($scope.users);
//	 }
//  });
 

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
				  return false;
			  }
		  }else{
			  $scope.lastname = true;
			  return false;
		  }
		  return true;
	  }else{
		  $scope.firstname = true;
		  return false;
	  }
  }
 
  $scope.addUser = function(data){
//	  if(validate($scope.us.firstName,$scope.us.lastName,$scope.us.number)){
//	  	$scope.addUserResp = 
	  	RestService.addUser(data).then(function(data){
	  		if(data.constructor === Array){
	  			for(i=0;i<data.length;i++){
	  				count = 0;
		  			for(j=0;j<$scope.users.length;j++){
		  				if(data[i].idUser == $scope.users[j].idUser) count++;
		  			}
		  			if(count==0) $scope.users.push(data[i]);
		  		}
	  		}
	  	});
	  }
  $scope.deleteUser = function(id){
	  RestService.deleteUser($scope.users[id].idUser,$scope.users[id].phones[0].idPhone).then(function(data){
		  	$scope.users.splice(id,1); 
		  if(data.value=="success"){
			  console.log("aaaaaa");
		  }
		  });
  }
});