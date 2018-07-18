(function(){
	var docID = getID("docID");
	//ajax对接后台
	function getData(docID){
		$.ajax({
			url:baseUrl+"/file/consbud/getconsbudall/"+docID,
			type:"GET",
			dataType:"json",
			success:function(res){
				//console.log(res.data)
				var result = res.data,
					item = res.data.item[0];
				//获取理财登记数据
				getBusinessData(result,item);
			}
		});			
	}

	//请求数据
	getData(docID);
	
	function getBusinessData(data,item) {
		var str ='<tr><th>调整单号</th><th>单据行项目号</th><th>基金中心</th><th>基金中心描述</th><th>承诺项目</th>'+
					'<th>承诺项目描述</th><th>期间</th><th>调整数</th><th>备注</th></tr>';
			str += '<tr><th>'+item.tzdh+'</th><th>'+item.djhh+'</th><th>'+item.fictr+'</th><th>'+item.bezeich+'</th><th>'+item.fylx+'</th><th>'+item.fyms+'</th><th>'+item.ysqj+'</th><th>'+item.adjst+'</th><th>'+item.bzxx+'</th></tr>';
			//str += '<tr><th>'+item.tzdh+'</th><th>'+item.djhh'</th></tr>';
		$(".page tbody").eq(1).append(str);
		var str1 = '<tr><th>单据编号</th><td>'+data.tzdh+'</td><th>财务管理范围</th><td>'+data.fikrs+'</td><th>调整类型</th>'+
					'<td>'+data.djlx+'</td><th>会计年度</th><td>'+data.gjahr+'</td><th>调整人</th><td>'+data.tizr+'</td><th>调整日期</th><td>'+data.tzrq+'</td><th>预算来源</th>'+
					'<td>'+data.ysly+'</td><th>专项类别</th><td>'+data.zxlb+'</td><th>摘要</th><td>'+data.wbzy+'</td></tr>';
		$(".page tbody").eq(0).append(str1);
	}
	//window.onload = getBusinessData;
})()


