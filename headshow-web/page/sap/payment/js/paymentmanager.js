var result ='';
function linkData(Src){
	var docID = getID("docID");
	//ajax对接后台
	function getData(docID){
		$.ajax({
			url:baseUrl+Src+docID,
			type:"GET",
                  dataType:"json",
                  cache:false,
			success:function(res){
				result = res.data;
				getBusinessData(result);
			}
		});			
	}

	//请求数据
	getData(docID);

	//监听当前屏幕宽度
	$(window).resize(function() {
      	getBusinessData(result);
	});
	function getBusinessData(data) {
      	var width = $(window).width();
		//获取本地表单数据
		$.getJSON("../json/dataList.json",function(dataJson){
			var dataList = dataJson["AP001"],//提取指定表单数据
			//抬头表
                  len = Math.ceil(dataList.val.length / 2),str='';
                  var headLen = dataList.val.length;				                                    
			//表1详情
			var t1Length = dataList.item.length;
			var t2Length = dataList.skdwItem.length;
                  var t1Head = '<tr><th>序号</th>';
                  var t2Head = '<tr><th>序号</th>';
                  var t1Body = '';
                  var t2Body = '';
                  t1Str = '';			
                  t2Str = '';			
			if(width > 520) {
				for(var i = 0 ; i < len ; i++){//循环数据
					str += '<tr><th>'+dataList.Key[i*2]+'</th>';
					if(dataList.Key[i*2+1]){
						str += '<td><input type="text" readonly value="'+(data[dataList.val[i*2]] != null || '' ? data[dataList.val[i*2]] : "空值")+
							'"/></td><th>'+ dataList.Key[i*2+1]+
							'</th><td><input type="text" readonly value="'+(data[dataList.val[i*2]] != null || '' ? data[dataList.val[i*2]] : "空值")+'"/></td></tr>';
					}else{
						str += '<td colspan="3"><input type="text" readonly value="'+(data[dataList.val[i*2]] != null || '' ? data[dataList.val[i*2]] : "空值")+'" /></td></tr>';
					}
				}
				//循环表1详情数据
                        for(var i = 0;i < t1Length;i++) {
                              t1Head += "<th>" +dataList.item.Key[i] + "</th>";
                        }

                        for(var i = 0;i < data.item.length;i++) {
                              t1Body += "<tr><td class='white'>"+(i+1)+"</td>";
                              for(var j = 0;j < t1Length;j++) {
                                    var key =  dataList.item.val[j];
                                    t1Body += "<td>" +(data.item[i][key] != null || '' ? data.item[i][key]: '空值') + "</td>";
                              }
                              t1Body += "</tr>";
                        }
                        //循环表2详情数据
				for(var i = 0;i < t2Length;i++) {
                              t2Head += "<th>" +dataList.skdwItem.Key[i] + "</th>";
                        }
                        for(var i = 0;i < data.skdwItem.length;i++) {
                              t2Body += "<tr><td class='white'>"+(i+1)+"</td>";
                              for(var j = 0;j < t2Length;j++) {
                                    var key =  dataList.skdwItem.val[j];
                                    t2Body += "<td>" +(data.skdwItem[i][key] != null || '' ? data.skdwItem[i][key] : '空值') + "</td>";
                              }
                              t2Body += "</tr>";
                        }                        
                        t2Head += "</tr>"; 
                        $(".table1 thead").html(t1Head);
                        $(".table1 tbody").html(t1Body);
                        $(".table2 thead").html(t2Head);
                        $(".table2 tbody").html(t2Body);
			}else {
				for(var i = 0;i < headLen;i++) {
					str += "<tr><th>"+dataList.Key[i]+"</th><td><input type='text' readonly value='"+(data[dataList.val[i]] != null || '' ? data[dataList.val[i]] : '空值')+"'/></td></tr>";
                        }
                        //表格一数据组数
                        var t1Len = data.item.length;
                        //循环表一详情数据
                        for(var i = 0;i < t1Len;i++) {
                              t1Str += "<table cellspacing='0' cellpadding='0'><caption>表格1</caption><thead></thead>";
                              t1Str += "<tr><th>序号</th><td class='white'>"+(i+1)+"</td></tr>";
                              for(var j = 0;j < t1Length;j++) {
                                    var key =  dataList.item.val[j];
                                    t1Str += "<tr><th>" + dataList.item.Key[j] + "</th><td>" + (data.item[i][key] != null || '' ? data.item[i][key]: '空值') + "</td></tr>";
                              }
                              t1Str += "</table>"
                        }

                        //表格二数据组数
                        var t2Len = data.skdwItem.length;
                        //循环表二详情数据
                        for(var i = 0;i < t2Len;i++) {
                              t2Str += "<table cellspacing='0' cellpadding='0'><caption>表格2</caption><thead></thead>";
                              t2Str += "<tr><th>序号</th><td class='white'>"+(i+1)+"</td></tr>";
                              for(var j = 0;j < t2Length;j++) {
                                    var key =  dataList.skdwItem.val[j];
                                    t2Str += "<tr><th>" + dataList.skdwItem.Key[j] + "</th><td>" + (data.skdwItem[i][key] != null || '' ? data.skdwItem[i][key]: '空值') + "</td></tr>";
                              }
                              t2Str += "</table>";
                        }                        
                        $(".page .table1").html(t1Str);
                        $(".page .table2").html(t2Str);
			}
			$(".page .head tbody").html(str);
		})
	}
}

