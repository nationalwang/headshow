function linkData(Src){
	var docID = getID("docID");
	//ajax对接后台
	function getData(docID){
		$.ajax({
			url:baseUrl+Src+docID,
			type:"GET",
			dataType:"json",
			success:function(res){
				console.log(res.data.bukrs)
				var result = res.data;
				//获取理财登记数据
				getBusinessData(result);
			}
		});			
	}

	//请求数据
	getData(docID);
	
	function getBusinessData(data) {

		//获取屏幕宽度
		var width = $(window).width();
		//获取本地表单数据
		$.getJSON("../json/dataList.json",function(dataJson){
			var dataList = dataJson["TR-TR034"],//提取指定表单数据
				len = Math.ceil(dataList.val.length / 2),str='';
				var headLen = dataList.val.length;				
			if(width >= 520) {
				for(var i = 0 ; i < len ; i++){//循环数据
					str += '<tr><th>'+dataList.Key[i*2]+'</th>';
					if(dataList.Key[i*2+1]){
						str += '<td><input type="text" placeholder="'+(data[dataList.val[i*2]] != null || '' ? data[dataList.val[i*2]] : "空")+
							'"/></td><th>'+ dataList.Key[i*2+1]+
							'</th><td><input type="text" placeholder="'+(data[dataList.val[i*2]] != null || '' ? data[dataList.val[i*2]] : "空")+'"/></td></tr>';
					}else{
						str += '<td colspan="3"><input type="text" placeholder="'+(data[dataList.val[i*2]] != null || '' ? data[dataList.val[i*2]] : "空")+'" /></td></tr>';
					}
				}			
			}else {
				for(var i = 0;i < headLen;i++) {
					str += "<tr><th>"+dataList.Key[i]+"</th><td>"+(data[dataList.val[i]] != null || '' ? data[dataList.val[i]] : '空值')+"</td></tr>";
				}
			}
			$(".page tbody").append(str);
		})
	}
}

