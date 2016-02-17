phones.directive('showError',['$document',function($document){
	return {
		link: function(scope,element,attr){
			scope.$watch('firstname',function(newValue,oldValue){
				console.log(newValue);
				if(newValue == true){
					element.attr("class","form-group has-error");
				}else{
					element.attr("class","form-group");
				}
			});
		}
	};
}]);