function linkData(Src){
	var docID = getID("docID");
	function getData(docID){
		$.ajax({
			url:baseUrl+Src+docID,
			type:"GET",
			dataType:"json",
			success:function(res){
				var result = res.data;
				//获取理财登记数据
				getBusinessData(result);
			}
		});			
	}

	//请求数据
	getData(docID);
	
	function getBusinessData(data) {
		//获取本地表单数据
		$.getJSON("../json/dataList.json",function(dataJson){
			var dataList = dataJson["TR-TR034"],//提取指定表单数据
				len = Math.ceil(dataList.val.length / 2),str='';
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
			$(".page tbody").append(str);
		})
	}
}

