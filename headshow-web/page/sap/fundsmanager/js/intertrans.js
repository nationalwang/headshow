(function(){
	var docID = getID("docID");
	//拼接url
	var url = "/identity/intertrans/getintertrans/"+docID;
	//对返回结果做异常处理
	getData(url,function(res){
		if(res.code == 0) {
			insertTableData(res.data);
			getPayDocSkdwItem(res.data.interTransItem);
		}else {
			alert(res.msg);
		}
	})

	//插入表头数据
	function insertTableData(data) {
		console.log(data);
		$("#ZDJBH").val(data.zdjbh != null || "" ? data.zdjbh : "空值");
		$("#ZCOM").val(data.zcom != null || "" ? data.zcom : "空值");
		$("#ZPC").val(data.zpc != null || "" ? data.zpc : "空值");
		$("#ZDJLX").val(data.zdjlx != null || "" ? data.zdjlx : "空值");
		$("#ZDDFX").val(data.zddfx != null || "" ? data.zddfx : "空值");
		$("#ZCREDATE").val(data.zcredate != null || "" ? data.zcredate : "空值");
		$("#ZCREBY").val(data.zcreby != null || "" ? data.zcreby : "空值");
	}
	function getPayDocSkdwItem(data) {
		//表格字符串
		var str = "<table class='table' cellspacing='0' cellpadding='0' border='1px'>"
				+ "<caption>表格一</caption>"
				+ "<tr>"
				+ "<th class='bg_blue title' id='ZNUM'>单据行号</th>"		
				+ "<th class='bg_blue title' id='ZDJRQ'>单据日期</th>"		
				+ "<th class='bg_blue title' id='ZSCOM'>收款公司</th>"		
				+ "<th class='bg_blue title' id='ZSPC'>收款利润中心</th>"	
				+ "<th class='bg_blue title' id='ZSKQY'>收款区域</th>"	
				+ "<th class='bg_blue title' id='ZSKBK'>收款板块</th>"	
				+ "<th class='bg_blue title' id='ZCDXZ'>收方存贷性质</th>"	
				+ "<th class='bg_blue title' id='ZNBZH'>收方内部账号</th>"	
				+ "<th class='bg_blue title' id='ZSSFFZ'>是否分灶</th>"	
				+ "<th class='bg_blue title' id='ZSBB'>币种</th>"	
				+ "<th class='bg_blue title' id='ZSZXM'>收支项目</th>"	
				+ "<th class='bg_blue title' id='ZZJJH'>资金计划项目</th>"	
				+ "<th class='bg_blue title' id='ZXJL'>现金流项目编码</th>"	
				+ "<th class='bg_blue title' id='ZSZJYT'>资金用途</th>"	
				+ "<th class='bg_blue title' id='ZFKGS'>付款公司</th>"	
				+ "<th class='bg_blue title' id='ZFKLRZX'>付款利润中心</th>"	
				+ "<th class='bg_blue title' id='ZFKQY'>付款区域</th>"	
				+ "<th class='bg_blue title' id='ZFKBK'>付款板块</th>"		
				+ "<th class='bg_blue title' id='ZFFCDXZ'>付方存贷性质</th>"		
				+ "<th class='bg_blue title' id='ZFFNBZH'>付方内部账号</th>"		
				+ "<th class='bg_blue title' id='ZFSFFZ'>是否分灶</th>"		
				+ "<th class='bg_blue title' id='ZFBB'>币种</th>"		
				+ "<th class='bg_blue title' id='ZFSZXM'>收支项目</th>"		
				+ "<th class='bg_blue title' id='ZFZJJH'>资金计划项目</th>"		
				+ "<th class='bg_blue title' id='ZFXJLL'>现金流项目编码 </th>"		
				+ "<th class='bg_blue title' id='ZZJYT'>资金用途</th>"		
				+ "<th class='bg_blue title' id='ZZJLX'>资金类型</th>"		
				+ "<th class='bg_blue title' id='ZJE'>金额</th>"		
				+ "<th class='bg_blue title' id='ZBZ'>备注</th>"		
				+ "<th class='bg_blue title' id='ZCREDATE'>创建时间</th>"		
				+ "<th class='bg_blue title' id='ZCREBY'>创建人</th>"		
				+ "<th class='bg_blue title' id='ZUPDDATE'>最后修改时间 </th>"		
				+ "<th class='bg_blue title' id='ZUPDBY'>最后修改人</th>"		
				+ "</tr>";	

		//数据组数
		var len = data.length;	
		for (var i = 0; i < len; i++) {
			str = str + "<tr>"	
				+ "<td class='content'>"+(data[i].znum != null || '' ? data[i].znum : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zdjrq != null || '' ? data[i].zdjrq : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zscom != null || '' ? data[i].zscom : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zspc != null || '' ? data[i].zspc : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zskqy != null || '' ? data[i].zskqy : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zskbk != null || '' ? data[i].zskbk : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zcdxz != null || '' ? data[i].zcdxz : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].znbzh != null || '' ? data[i].znbzh : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zssffz != null || '' ? data[i].zssffz : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zsbb != null || '' ? data[i].zsbb : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zszxm != null || '' ? data[i].zszxm : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zzjjh != null || '' ? data[i].zzjjh : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zxjl != null || '' ? data[i].zxjl : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zszjyt != null || '' ? data[i].zszjyt : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfkgs != null || '' ? data[i].zfkgs : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfklrzx != null || '' ? data[i].zfklrzx : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfkqy != null || '' ? data[i].zfkqy : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfkbk != null || '' ? data[i].zfkbk : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zffcdxz != null || '' ? data[i].zffcdxz : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zffnbzh != null || '' ? data[i].zffnbzh : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfsffz != null || '' ? data[i].zfsffz : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfbb != null || '' ? data[i].zfbb : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfszxm != null || '' ? data[i].zfszxm : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfzjjh != null || '' ? data[i].zfzjjh : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfxjll != null || '' ? data[i].zfxjll : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zzjyt != null || '' ? data[i].zzjyt : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zje != null || '' ? data[i].zje : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zbz != null || '' ? data[i].zbz : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zcredate != null || '' ? data[i].zcredate : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zcreby != null || '' ? data[i].zcreby : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zupddate != null || '' ? data[i].zupddate : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zupdby != null || '' ? data[i].zupdby : '空值')+"</td>"
				+ "</tr>";
		}
		str += "</table>";
		//渲染表格字符串
		$('.tableOne').html(str);					
	}
})();