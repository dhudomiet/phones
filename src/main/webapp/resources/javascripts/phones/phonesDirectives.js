phones.directive('showError',['$document',function($document){
	return {
		link: function(scope,element,attr){
			scope.$watch('firstname',function(newValue,oldValue){
				console.log(newValue);
				if(newValue != oldValue){
					element.attr("class","form-group has-error");
				}else{
					element.attr("class","form-group");
				}
			});
			
			scope.$watch('lastname',function(newValue,oldValue){
				if(newValue != oldValue){
					element.attr("class","form-group has-error");
				}else{
					element.attr("class","form-group");
				}
			});
			
			scope.$watch('number',function(newValue,oldValue){
				if(newValue != oldValue){
					element.attr("class","form-group has-error");
				}else{
					element.attr("class","form-group");
				}
			});
		}
	};
}]);

phones.directive('setData',['$document',function($document){
	return {
		link : function(scope,element,attr){
			scope.$watch('idUser',function(newValue,oldValue){
				$scope.idUser = element.val();
			});
		}
	};
}]);