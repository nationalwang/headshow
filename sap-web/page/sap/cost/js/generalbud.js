var result = '';
function linkData(Src){
	  var docID = getID("docID");
	  console.log(docID);
      //ajax对接后台
      function getData(docID){
            $.ajax({
                  url:baseUrl+Src+docID,
                  type:"GET",
                  dataType:"json",
                  cache:false,
                  success:function(res){
				result = res.data;
                        //获取理财登记数据
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
                  var dataList = dataJson["FM007"],//提取指定表单数据
                  //抬头表
                  len = Math.ceil(dataList.val.length / 2),str='';
                  var headLen = dataList.val.length;				                                                           
                  //表1详情
                  var t1Length = dataList.budgetRowItemDTOs.length;
                  var t1Head = '<tr><th>序号</th>';
                  var t1Body = '';
                  t1Str = '';
                  //表格一数据组数
                  var t1Len = data.budgetRowItemDTOs.length;
                  if(width > 520) {
                        //循环抬头数据
                        for(var i = 0 ; i < len ; i++){
                              str += '<tr><th>'+dataList.Key[i*2]+'</th>';
                              if(dataList.Key[i*2+1]){
                                    str += '<td><input type="text" readonly value="'+(data[dataList.val[i*2]] != null || '' ? data[dataList.val[i*2]] : "空")+
                                          '"/></td><th>'+ dataList.Key[i*2+1]+
                                          '</th><td><input type="text" readonly value="'+(data[dataList.val[i*2]] != null || '' ? data[dataList.val[i*2]] : "空")+'"/></td></tr>';
                              }else{
                                    str += '<td colspan="3"><input type="text" readonly value="'+(data[dataList.val[i*2]] != null || '' ? data[dataList.val[i*2]] : "空")+'" /></td></tr>';
                              }
                        }
                        //循环表1详情数据
                        for(var i = 0;i < t1Length;i++) {
                              t1Head += "<th>" +dataList.budgetRowItemDTOs.Key[i] + "</th>";
                        }
                        for(var i = 0;i < t1Len;i++) {
                              t1Body += "<tr><td class='white'>"+(i+1)+"</td>";
                              for(var j = 0;j < t1Length;j++) {
                                    var key =  dataList.budgetRowItemDTOs.val[j];
                                    t1Body += "<td>" +(data.budgetRowItemDTOs[i][key] != null || '' ? data.budgetRowItemDTOs[i][key] : "空值") + "</td>";
                              }
                              t1Body += "</tr>";
                        } 
                        t1Head += "</tr>";  
                        $(".table1 thead").html(t1Head);
                        $(".table1 tbody").html(t1Body); 
                  }else {
                        for(var i = 0;i < headLen;i++) {
                              str += "<tr><th>"+dataList.Key[i]+"</th><td><input type='text' readonly value='"+(data[dataList.val[i]] != null || '' ? data[dataList.val[i]] : '空值')+"'/></td></tr>";
                        }

                        //循环表一详情数据
                        for(var i = 0;i < t1Len;i++) {
                              t1Str += "<table cellspacing='0' cellpadding='0'><caption>表格1</caption><thead></thead>";
                              t1Str += "<tr><th>序号</th><td class='white'>"+(i+1)+"</td></tr>";
                              for(var j = 0;j < t1Length;j++) {
                                    var key =  dataList.budgetRowItemDTOs.val[j];
                                    t1Str += "<tr><th>" + dataList.budgetRowItemDTOs.Key[j] + "</th><td>" + (data.budgetRowItemDTOs[i][key] != null || '' ? data.budgetRowItemDTOs[i][key]: '空值') + "</td></tr>";
                              }
                              t1Str += "</table>"
                        }
                        $(".page .table1").html(t1Str);                        
                  }

                  //渲染字符串
                  $(".page .head tbody").html(str);
            })
      }
}

