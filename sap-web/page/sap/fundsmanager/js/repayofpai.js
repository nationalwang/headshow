(function(){
	var docID = getID("docID");
	//拼接url
	var url = "/identity/repayofpai/getrepayofpai/"+docID;
	//对返回结果做异常处理
	getData(url,function(res){
		if(res.code == 0) {
			insertTableData(res.data);
			getPayDocSkdwItem(res.data.repayOfPAIItem);
			console.log(res.data.repayOfPAIItem);
		}else {
			alert(res.msg);
		}
	})

	//插入表头数据
	function insertTableData(data) {
		$("#URL").val(data.url != null || "" ? data.url : "空值");
		$("#BUKRS").val(data.bukrs != null || "" ? data.bukrs : "空值");
		$("#ZDJBH").val(data.zdjbh != null || "" ? data.zdjbh : "空值");
		$("#ZDJLX").val(data.zdjlx != null || "" ? data.zdjlx : "空值");
		$("#ZDJLX_MS").val(data.zdjlx_ms != null || "" ? data.zdjlx_ms : "空值");
		$("#PRCTR").val(data.prctr != null || "" ? data.prctr : "空值");
		$("#PRCTR_MS").val(data.prctr_ms != null || "" ? data.prctr_ms : "空值");
		$("#KOSTL").val(data.kostl != null || "" ? data.kostl : "空值");
		$("#KOSTL_MS").val(data.kostl_ms != null || "" ? data.kostl_ms : "空值");
		$("#ZSHZK_MS").val(data.zshzk_ms != null || "" ? data.zshzk_ms : "空值");
		$("#ZLCBT").val(data.zlcbt != null || "" ? data.zlcbt : "空值");
		$("#ZJFDATE").val(data.zjfdate != null || "" ? data.zjfdate : "空值");
		$("#WAERS").val(data.waers != null || "" ? data.waers : "空值");
		$("#KURSF").val(data.kursf != null || "" ? data.kursf : "空值");
		$("#ZZBSCZFQ_MS").val(data.zzbsczfq_ms != null || "" ? data.zzbsczfq_ms : "空值");
		$("#ZXYXQXY_MS").val(data.zxyxqxy_ms != null || "" ? data.zxyxqxy_ms : "空值");
		$("#ZSH9XQY").val(data.zsh9xqy != null || "" ? data.zsh9xqy : "空值");
		$("#ZSH9XQY_MS").val(data.zsh9xqy_ms != null || "" ? data.zsh9xqy_ms : "空值");
		$("#ZSHDRJH").val(data.zshdrjh != null || "" ? data.zshdrjh : "空值");
		$("#ZSHDRJH_MS").val(data.zshdrjh_ms != null || "" ? data.zshdrjh_ms : "空值");
		$("#ZSHXYQD").val(data.zshxyqd != null || "" ? data.zshxyqd : "空值");
		$("#ZSHXYQD_MS").val(data.zshxyqd_ms != null || "" ? data.zshxyqd_ms : "空值");
		$("#ZSHYNN").val(data.zshynn != null || "" ? data.zshynn : "空值");
		$("#ZSHYNN_MS").val(data.zshynn_ms != null || "" ? data.zshynn_ms : "空值");
		$("#ZYLJZFJE").val(data.zyljzfje != null || "" ? data.zyljzfje : "空值");
		$("#ZLJZFJZRQ").val(data.zljzfjzrq != null || "" ? data.zljzfjzrq : "空值");
		$("#ZBCZJE1").val(data.zbczje1 != null || "" ? data.zbczje1 : "空值");
		$("#ZBCZJE2").val(data.zbczje2 != null || "" ? data.zbczje2 : "空值");
		$("#ACC_NUM").val(data.acc_num != null || "" ? data.acc_num : "空值");
		$("#BENEFICIAL").val(data.beneficial != null || "" ? data.beneficial : "空值");
		$("#BANKL").val(data.bankl != null || "" ? data.bankl : "空值");
		$("#DESCRIPTION").val(data.description != null || "" ? data.description : "空值");
		$("#PARTNER_MS").val(data.partner_ms != null || "" ? data.partner_ms : "空值");
		$("#ZBANKN").val(data.zbankn != null || "" ? data.zbankn : "空值");
		$("#ZKOINH").val(data.zkoinh != null || "" ? data.zkoinh : "空值");
		$("#ZBANKL").val(data.zbankl != null || "" ? data.zbankl : "空值");
		$("#ZBANKA").val(data.zbanka != null || "" ? data.zbanka : "空值");
		$("#GSBER_MS").val(data.gsber_ms != null || "" ? data.gsber_ms : "空值");
		$("#ZSSQY_MS").val(data.zssqy_ms != null || "" ? data.zssqy_ms : "空值");
		$("#ZRZFB_MS").val(data.zrzfb_ms != null || "" ? data.zrzfb_ms : "空值");
		$("#ZXGSM").val(data.zxgsm != null || "" ? data.zxgsm : "空值");
		$("#ZFKDNO").val(data.zfkdno != null || "" ? data.zfkdno : "空值");
		$("#ZZKDNO").val(data.zzkdno != null || "" ? data.zzkdno : "空值");
		$("#ZJSZT_MS").val(data.zjszt_ms != null || "" ? data.zjszt_ms : "空值");
		$("#ZSPZT_MS").val(data.zspzt_ms != null || "" ? data.zspzt_ms : "空值");
		$("#ZDJZT_MS").val(data.zdjzt_ms != null || "" ? data.zdjzt_ms : "空值");
		$("#ZCREDATE").val(data.zcredate != null || "" ? data.zcredate : "空值");
		$("#ZCREBY").val(data.zcreby != null || "" ? data.zcreby : "空值");
		$("#TEL_NUMBER").val(data.tel_number != null || "" ? data.tel_number : "空值");
	}
	function getPayDocSkdwItem(data) {
		//表格字符串
		var str = "<table class='table' cellspacing='0' cellpadding='0' border='1px'>"
				+ "<caption>表格一</caption>"
				+ "<tr>"
				+ "<th class='bg_blue title' id='ZDJHBH'>单据行项目</th>"		
				+ "<th class='bg_blue title' id='ZDKHTBH'>贷款合同编号</th>"		
				+ "<th class='bg_blue title' id='ZFKDH'>放款单号</th>"		
				+ "<th class='bg_blue title' id='ZXMLX_MS'>项目类型描述</th>"	
				+ "<th class='bg_blue title' id='ZJE_Y'>金额(原币)</th>"	
				+ "<th class='bg_blue title' id='ZJE_B'>金额(本币)</th>"	
				+ "<th class='bg_blue title' id='ZJE_SJ'>实际金额(本币)</th>"	
				+ "<th class='bg_blue title' id='ZJEQSRQ'>金额起始日期</th>"	
				+ "<th class='bg_blue title' id='ZJEZZRQ'>金额终止日期</th>"	
				+ "<th class='bg_blue title' id='ZSZXM_MS'>收支项目</th>"	
				+ "<th class='bg_blue title' id='ZJFXM_MS'>计划项目</th>"	
				+ "<th class='bg_blue title' id='ZXJLLXM_MS'>现金流量项目</th>"	
				+ "<th class='bg_blue title' id='ZHTJE'>合同金额</th>"	
				+ "<th class='bg_blue title' id='ZFKJE'>放款金额</th>"	
				+ "<th class='bg_blue title' id='ZHTQSRQ'>合同起始日期</th>"	
				+ "<th class='bg_blue title' id='ZHTJSRQ'>合同结束日期</th>"	
				+ "<th class='bg_blue title' id='ZJKDW_MS'>借款单位</th>"	
				+ "<th class='bg_blue title' id='ZDKYH_MS'>贷款银行</th>"		
				+ "</tr>";	

		//数据组数
		var len = data.length;	
		for (var i = 0; i < len; i++) {
			str = str + "<tr>"	
				+ "<td class='content'>"+(data[i].zdjhbh != null || '' ? data[i].zdjhbh : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zdkhtbh != null || '' ? data[i].zdkhtbh : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfkdh != null || '' ? data[i].zfkdh : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zxmlx_ms != null || '' ? data[i].zxmlx_ms : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zje_y != null || '' ? data[i].zje_y : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zje_b != null || '' ? data[i].zje_b : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zje_sj != null || '' ? data[i].zje_sj : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zjeqsrq != null || '' ? data[i].zjeqsrq : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zjezzrq != null || '' ? data[i].zjezzrq : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zszxm_ms != null || '' ? data[i].zszxm_ms : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zjfxm_ms != null || '' ? data[i].zjfxm_ms : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zxjllxm_ms != null || '' ? data[i].zxjllxm_ms : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zhtje != null || '' ? data[i].zhtje : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zfkje != null || '' ? data[i].zfkje : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zhtqsrq != null || '' ? data[i].zhtqsrq : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zhtjsrq != null || '' ? data[i].zhtjsrq : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zjkdw_ms != null || '' ? data[i].zjkdw_ms : '空值')+"</td>"
				+ "<td class='content'>"+(data[i].zdkyh_ms != null || '' ? data[i].zdkyh_ms : '空值')+"</td>"
				+ "</tr>";
		}
		str += "</table>";
		//渲染表格字符串
		$('.tableOne').html(str);					
	}
})();