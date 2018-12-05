//游戏种类的二级联动
function querySmallType()
{   
	var select=$('#SmallType');
	select.html("");
	var bigGameSelect=$('#ArticleBigType option:selected').text();
	$.ajax({
		type:"post", 
		url: 'querySmallTypeNameByBigId',
	    dataType: 'json',
	    data:"name="+bigGameSelect,
	    success: function(data){
	    	 var select=$('#SmallType');
	    	 var html="";
	    	 for(var i = 0;i<=data.length-1;i++){
	               html += "<option value='"+data[i]+"'>"+data[i]+"</option>"
	           }
	         select.html(html);
	    }
	});
}