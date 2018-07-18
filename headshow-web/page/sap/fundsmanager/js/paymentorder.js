(function(){
	var docID = getID("docID");
	//拼接url
	var url = "/identity/getpaymentorder/"+docID;
	//对返回结果做异常处理
	getData(url,function(res){
		if(res.code == 0) {
			insertTableData(res.data);
			getPayDocSkdwItem(res.data.paymentOrderItem);
		}else {
			alert(res.msg);
		}
	})	

	//支付详情表格1
	function getPayDocSkdwItem(data) {
		//表格字符串
		var str = "<table class='table' cellspacing='0' cellpadding='0' border='1px'>"
				+ "<caption>表格一</caption>"
				+ "<tr>"
				+ "<th class='bg_blue title' id='ZFKDNO'>付款单号</th>"		
				+ "<th class='bg_blue title' id='ZFKDJHNO'>付款单据行项目</th>"		
				+ "<th class='bg_blue title' id='YFDH'>来源单据号</th>"		
				+ "<th class='bg_blue title' id='YFDHNO'>来源单据行项目</th>"	
				+ "<th class='bg_blue title' id='SY'>事由</th>"	
				+ "<th class='bg_blue title' id='FYLX'>费用类型</th>"	
				+ "<th class='bg_blue title' id='YSZYDW'>预算占用单位</th>"	
				+ "<th class='bg_blue title' id='YSZYBM'>预算占用部门</th>"	
				+ "<th class='bg_blue title' id='HSRZBM'>核算入账部门</th>"	
				+ "<th class='bg_blue title' id='HKONT'>会计科目</th>"	
				+ "<th class='bg_blue title' id='XMQQ'>项目期区</th>"	
				+ "<th class='bg_blue title' id='TZKXLX'>投策款项类型</th>"	
				+ "<th class='bg_blue title' id='GZDW'>挂账单位</th>"	
				+ "<th class='bg_blue title' id='WAERS'>币种</th>"	
				+ "<th class='bg_blue title' id='KURSF'>汇率</th>"	
				+ "<th class='bg_blue title' id='YBJE'>原币金额</th>"	
				+ "<th class='bg_blue title' id='BBJE'>本币金额</th>"	
				+ "<th class='bg_blue title' id='ZKLDJE'>可拉单金额</th>"	
				+ "<th class='bg_blue title' id='ZBCZFJE'>本次支付金额</th>"	
				+ "<th class='bg_blue title' id='ZSYLDJE'>剩余拉单金额</th>"	
				+ "<th class='bg_blue title' id='ZSZXM'>收支项目</th>"	
				+ "<th class='bg_blue title' id='ZZJJH'>资金计划项目</th>"	
				+ "<th class='bg_blue title' id='ZXJLL'>现金流量项目</th>"	
				+ "</tr>";	

		//数据组数
		var len = data.length;	
		for (var i = 0; i < len; i++) {
			str = str + "<tr>"	
				+ "<td class='content'>"+(data[i].zfkdno != null || '' ? data[i].zfkdno : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfkdjhno != null || '' ? data[i].zfkdjhno : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].yfdh != null || '' ? data[i].yfdh : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].yfdhno != null || '' ? data[i].yfdhno : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].sy != null || '' ? data[i].sy : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].fylx != null || '' ? data[i].fylx : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].yszydw != null || '' ? data[i].yszydw : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].yszybm != null || '' ? data[i].yszybm : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].hsrzbm != null || '' ? data[i].hsrzbm : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].hkont != null || '' ? data[i].hkont : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].xmqq != null || '' ? data[i].xmqq : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].tzkxlx != null || '' ? data[i].tzkxlx : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].gzdw != null || '' ? data[i].gzdw : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].waers != null || '' ? data[i].waers : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].kursf != null || '' ? data[i].kursf : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].ybje != null || '' ? data[i].ybje : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].bbje != null || '' ? data[i].bbje : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zkldje != null || '' ? data[i].zkldje : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zbczfje != null || '' ? data[i].zbczfje : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zsyldje != null || '' ? data[i].zsyldje : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zszxm != null || '' ? data[i].zszxm : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zzjjh != null || '' ? data[i].zzjjh : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zxjll != null || '' ? data[i].zxjll : '空值')+"</td>"
				+ "</tr>";
		}
		str += "</table>";
		//渲染表格字符串
		$('.tableOne').html(str);					
	}

	//插入表头数据
	function insertTableData(data) {
		$("#BUKRS").val(data.bukrs != null || "" ? data.bukrs : "空值");
		$("#PRCTR").val(data.prctr != null || "" ? data.prctr : "空值");
		$("#KOSTL").val(data.kostl != null || "" ? data.kostl : "空值");
		$("#ZFKDLX").val(data.zfkdlx != null || "" ? data.zfkdlx : "空值");
		$("#ZFKDNO").val(data.zfkdno != null || "" ? data.zfkdno : "空值");
		$("#ZDZBSM").val(data.zdzbsm != null || "" ? data.zdzbsm : "空值");
		$("#YFDH").val(data.yfdh != null || "" ? data.yfdh : "空值");
		$("#YWLX").val(data.ywlx != null || "" ? data.ywlx : "空值");
		$("#ZFFKDNUM").val(data.zffkdnum != null || "" ? data.zffkdnum : "空值");
		$("#LYXT").val(data.lyxt != null || "" ? data.lyxt : "空值");
		$("#SKDW").val(data.skdw != null || "" ? data.skdw : "空值");
		$("#DJZT").val(data.djzt != null || "" ? data.djzt : "空值");
		$("#YQFKSJ").val(data.yqfksj != null || "" ? data.yqfksj : "空值");
		$("#HTH").val(data.hth != null || "" ? data.hth : "空值");
		$("#FLG_JJFK").val(data.flgJjfk != null || "" ? data.flgJjfk : "空值");
		$("#FLG_GX").val(data.flgGx != null || "" ? data.flgGx : "空值");
		$("#SKYHZH").val(data.skyhzh != null || "" ? data.skyhzh : "空值");
		$("#SKDWHM").val(data.skdwhm != null || "" ? data.skdwhm : "空值");
		$("#SKBANKL").val(data.skbankl != null || "" ? data.skbankl : "空值");
		$("#ZJSFS").val(data.zjsfs != null || "" ? data.zjsfs : "空值");
		$("#ZFKYHZH").val(data.zfkyhzh != null || "" ? data.zfkyhzh : "空值");
		$("#ZFKYHZHM").val(data.zfkyhzhm != null || "" ? data.zfkyhzhm : "空值");
		$("#FKBANKL").val(data.fkbankl != null || "" ? data.fkbankl : "空值");
		$("#WAERS").val(data.waers != null || "" ? data.waers : "空值");
		$("#KURSF").val(data.kursf != null || "" ? data.kursf : "空值");
		$("#YBJE").val(data.ybje != null || "" ? data.ybje : "空值");
		$("#BBJE").val(data.bbje != null || "" ? data.bbje : "空值");
		$("#ZKLDJE").val(data.zkldje != null || "" ? data.zkldje : "空值");
		$("#ZBCZFJE").val(data.zbczfje != null || "" ? data.zbczfje : "空值");
		$("#ZSYLDJE").val(data.zsyldje != null || "" ? data.zsyldje : "空值");
		$("#DFGS").val(data.dfgs != null || "" ? data.dfgs : "空值");
		$("#DFLRZX").val(data.dflrzx != null || "" ? data.dflrzx : "空值");
		$("#DFYFD").val(data.dfyfd != null || "" ? data.dfyfd : "空值");
		$("#BDFGS").val(data.bdfgs != null || "" ? data.bdfgs : "空值");
		$("#BDFLRZX").val(data.bdflrzx != null || "" ? data.bdflrzx : "空值");
		$("#BDFYFD").val(data.bdfyfd != null || "" ? data.bdfyfd : "空值");
		$("#FLG_BDFGSYCL").val(data.flgBdfgsycl != null || "" ? data.flgBdfgsycl : "空值");
		$("#SY").val(data.sy != null || "" ? data.sy : "空值");
		$("#ZTXT").val(data.ztxt != null || "" ? data.ztxt : "空值");
		$("#ZBWTXT").val(data.zbwtxt != null || "" ? data.zbwtxt : "空值");
		$("#ZDJSPZT").val(data.zdjspzt != null || "" ? data.zdjspzt : "空值");
		$("#ZZFZT").val(data.zzfzt != null || "" ? data.zzfzt : "空值");
		$("#ZFLG_ZFTFZT").val(data.zflgZftfzt != null || "" ? data.zflgZftfzt : "空值");
		$("#ZBTBL").val(data.zbtbl != null || "" ? data.zbtbl : "空值");
		$("#ZSPZT").val(data.zspzt != null || "" ? data.zspzt : "空值");
		$("#ZUUID").val(data.zuuid != null || "" ? data.zuuid : "空值");
		$("#ZBLGS").val(data.zblgs != null || "" ? data.zblgs : "空值");
		$("#ZTJSPRQ").val(data.ztjsprq != null || "" ? data.ztjsprq : "空值");
		$("#ZSPH").val(data.zsph != null || "" ? data.zsph : "空值");
		$("#ZSPRQ").val(data.zsprq != null || "" ? data.zsprq : "空值");
		$("#ZQZNAM").val(data.zqznam != null || "" ? data.zqznam : "空值");
		$("#ZQZSJ").val(data.zqzsj != null || "" ? data.zqzsj : "空值");
		$("#ZZFNAM").val(data.zzfnam != null || "" ? data.zzfnam : "空值");
		$("#ZZFSJ").val(data.zzfsj != null || "" ? data.zzfsj : "空值");
		$("#ZDR").val(data.zdr != null || "" ? data.zdr : "空值");
		$("#CJRQ").val(data.cjrq != null || "" ? data.cjrq : "空值");
		$("#ERDAT").val(data.erdat != null || "" ? data.erdat : "空值");
		$("#ZYJZFRQ").val(data.zyjzfrq != null || "" ? data.zyjzfrq : "空值");
		$("#ZSJZFRQ").val(data.zsjzfrq != null || "" ? data.zsjzfrq : "空值");
	}
})()