var result = '';
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
                  var dataList = dataJson["TR020-02"],//提取指定表单数据
                  //抬头表
                  len = Math.ceil(dataList.val.length / 2),str='';
                  var headLen = dataList.val.length;
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
                  }else {
                        for(var i = 0;i < headLen;i++) {
                              str += "<tr><th>"+dataList.Key[i]+"</th><td><input type='text' readonly value='"+(data[dataList.val[i]] != null || '' ? data[dataList.val[i]] : '空值')+"'/></td></tr>";
                        }                       
                  }
                  //渲染字符串
                  $(".page .head tbody").html(str);
            })
      }
}

