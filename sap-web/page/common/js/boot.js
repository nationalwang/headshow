function __CreateJSPath(js) {
    var scripts = document.getElementsByTagName("script");
    var path = "";
    for (var i = 0, l = scripts.length; i < l; i++) {
        var src = scripts[i].src;
        if (src.indexOf(js) != -1) {
            var ss = src.split(js);
            path = ss[0];
            break;
        }
    }
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss.length = ss.length - 1;
    href = ss.join("/");
    if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
        path = href + "/" + path;
    }
    return path;
}

var bootPATH = __CreateJSPath("boot.js"),
	jsType = 'type="text/javascript" charset="utf-8"',
	cssTpye = 'rel="stylesheet" type="text/css"';
document.write('<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">');
document.write('<script '+ jsType +' src="' + bootPATH + 'jquery/jquery-1.8.3.min.js"></sc' + 'ript>');
document.write('<script '+ jsType +' src="' + bootPATH + 'iconfont.js"></sc' + 'ript>');
document.write('<script '+ jsType +' src="' + bootPATH + 'common.js"></sc' + 'ript>');
document.write('<link '+cssTpye+' href="' + bootPATH + '../css/base.css"/>');

function getWindowSize(){
	var width=top.document.documentElement.clientWidth;
	var height=top.document.documentElement.clientHeight;
	return {w:width,h:height};
}
