//配置ip地址
var baseUrl = "http://10.10.179.60:7002";  	//服务器
//var baseUrl = "http://10.187.9.12:7002";	//宇轩 
// var baseUrl = "http://10.187.63.65:7002";//刘放tempID=FM053&act=1&docID=1      tempID=TR034_1&act=1&docID=98K 
//var baseUrl = "http://10.187.33.156:7002";  //颜光    tempID=TR034_3&act=1&docID=98K  tempID=TR034_3&act=1&docID=1
// var baseUrl = "http://10.187.50.198:7002";	//志强

//截取url参数
function getID(key) {
	var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
	var result = window.location.search.substr(1).match(reg);
	return result ? decodeURIComponent(result[2]) : null;
}

//跳转页面
function changePage() {
	var nodeID = getID("act");
	//流程ID
	var tempID = getID("tempID");
	//单号ID
	var docID = getID("docID");
	//默认nodeID为1
	if(nodeID == "") {
		nodeID = 1;
	}

	$(function(){
		$.ajax({
			url : baseUrl+"/formmanager/getpageofnode/"+tempID+"/"+nodeID,
			type: "GET",
			dataType:"json",
			cache:false,
			success: function(res) {
				if( res.code == 0 ){
					var fileEnd = res.data.lastIndexOf('.'),
					fileName = res.data.slice(0,fileEnd-1),
					fileSer = 'accapplyalter1,accapplyacc,applyalter,accapplycloseacc,consbudget,refundorder,paymentmanager,refundorderyztk,refundorderzltk,generalbud,specspectransr,initbud,settexch,fundtrans,specialbud,floordedfund';
					if( fileSer.match(fileName) ){
						$('head').append('<link '+cssTpye+' href="' + bootPATH + '../css/common.css"/>');
						$('head').append('<script '+ jsType +' src="js/'+fileName+'.js"></sc' + 'ript>');
					}
					$('body').load(res.data);
				}else{
					var error = "<h3>"+res.msg+"</h3>";
					$("body").html(error);
				}
			}
		});		
	});
}


function getData(url,callback) {
	console.log(baseUrl+url);
	$.ajax({
		url:baseUrl+url,
		type:"GET",
		cache:false,
		dataType:"json",
		success:function(res){
			return callback(res);
		}
	});	
}

function linkDataTest(Src,formID,mobile){
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
			var dataList = dataJson[formID],//提取指定表单数据
				col =  2,
				len = Math.ceil(dataList.val.length / col),
				ipt = '<input type="text" placeholder="',
				str='';
				
			for(var i = 0 ; i < len ; i++){//循环数据
				str += '<tr>';
				for( var t = 0 ; t < col ; t++ ){
					if( dataList.Key[i*col+t+1] ){
						str += '<th>'+dataList.Key[i*col+t]+'</th><td>'+ipt+dataList.val[i*col+t]+'"/></td>';
					}else{
						str += '<th>'+dataList.Key[i*col+t]+'</th><td colspan="'+(col*2-t*2-1)+'">'+ipt+dataList.val[i*col+t]+'"/></td>';
						break;	
					}
				}
				str += '</tr>';
			}
			$(".page tbody").empty().append(str);
		})
	}
}

$(window).resize(function(){
	if( getWidth() < 560 ){
		linkData()
	}
})

function getWidth(){
	return $(window).width();
}
