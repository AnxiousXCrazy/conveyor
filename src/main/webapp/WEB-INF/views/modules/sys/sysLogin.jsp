<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${fns:getConfig('productName')} 登录</title>
	<meta name="decorator" content="blank"/>
	<style type="text/css">
		body, p, form {
		    margin: 0 !important;
		}
		input{
		    font-size: 100% !important;
		}
		img {
		    border: 0 !important;
		}
		a {
		    text-decoration: none !important;
		    color: inherit !important;
		    -webkit-tap-highlight-color:rgba(0,0,0,0) !important;
		}
		
		input[type="text"]::-ms-clear,
		input[type="password"]::-ms-clear {
		    width: 0 !important;
		    height: 0 !important;
		}
		input[type="text"]::-ms-reveal,
		input[type="password"]::-ms-reveal {
		    width: 0 !important;
		    height: 0 !important;
		}
		input[type="checkbox"]{
		    margin: 0 8px 0 0 !important;
		    vertical-align: -3px !important;
		}
		::-webkit-input-placeholder {
		    color: #999 !important;
		}
		:-moz-placeholder {
		    color: #999 !important;
		}
		::-moz-placeholder {
		    color: #999 !important;
		}
		:-ms-input-placeholder {
		    color: #999 !important;
		}
		html,body {
		    height: 100%;
		    font: 14px/1.5 "\5FAE\8F6F\96C5\9ED1", sans-serif !important;  /* Microsoft YaHei */
		}
		
		.header {
		    position: relative !important;
		    height: 70px !important;
		    width: 100% !important;
		    background-color: #fff !important;
		    z-index: 1 !important;
		    overflow: auto !important;
		}
		.header img {
		    margin: 12px 0 0 38px !important;
		}
		.sys-title {
		    font-size: 24px !important;
		    margin-left: 22px !important;
		    vertical-align: top !important;
		    line-height: 70px !important;
		    color: #333 !important;
		}
		input:focus {
		    outline: none !important;
		}
		
		.login-bg {
		    position: fixed !important;
		    height: 100% !important;
		    width: 100% !important;
		    left: 0 !important;
		    top: 0 !important;
		}
		
		.login-main {
		    position: relative !important;
		    width: 350px !important;
		    background-color: #fafafa !important;
		    margin: 100px auto 0 !important;
		    z-index: 1 !important;
		    border-radius: 5px !important;
		    -webkit-box-shadow:  0 0 8px  #426c90 !important;
		    -moz-box-shadow:  0 0 8px  #426c90 !important;
		    box-shadow:  0 0 8px  #426c90 !important;
		}
		
		.login-header {
		    height: 50px !important;
		    font-size: 20px !important;
		    line-height: 50px !important;
		    background-color: #e5e5e5 !important;
		    border-radius: 5px 5px 0 0 !important;
		    text-indent: 24px !important;
		    color: #000 !important;
		    border-bottom: 1px solid #dcdcdc !important;
		}
		
		.login-content {
		    padding: 0 24px 64px 24px !important;
		}
		.input-wrap {
		    margin-top: 24px !important;
		}
		.login-input,
		.verify-input {
		    -webkit-box-sizing: border-box !important;
		    -moz-box-sizing: border-box !important;
		    box-sizing: border-box !important;
		    box-sizing: border-box !important;
		    height: 43px !important;
		    text-indent: 4px !important;
		    border: 1px solid #dcdcdc !important;
		    border-radius: 5px !important;
		    width: 100% !important;
		}
		.login-input:focus ,
		.verify-input:focus {
		    border: 1px solid #00A4F4 !important;
		}
		.remember-me {
		    display: inline-block !important;
		    margin-top: 4px !important;
		    line-height: 24px !important;
		    color: #999 !important;
		}
		.login-submit {
		    display: block !important;
		    margin-top: 20px !important;
		    height: 45px !important;
		    font-size: 18px !important;
		    line-height: 45px !important;
		    color: #fff !important;
		    background-color: #00A4BB !important;
		    border-radius: 4px !important;
		    text-align: center !important;
		    letter-spacing: 8px !important;
		}
		.login-submit:hover {
		    background-color: #00a4e1 !important;
		}
		.login-submit:active {
		    background-color: #00aaee !important;
		}
		.verify-info {
		    color: #f60 !important;
		    padding: 6px 0 !important;
		    line-height: 22px !important;
		}
		.line-wrap {
		    position: relative !important;
		}
		.verify-wrap {
		    position: absolute !important;
		    top: 4px !important;
		    right: 0 !important;
		}
		.verify-input {
		    height: 24px !important;
		    width: 60px !important;
		    padding: 0 !important;
		}
		.verify-code {
		    height: 24px !important;
		    width: 50px !important;
		    vertical-align: bottom !important;
		    border: none !important;
		    margin-left: 10px !important;
		    border-radius: 4px !important;
		}
      	label.error{margin-left: 0px;padding-left:0px; background: none;margin-right: 10px;}
    </style>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#loginForm").validate({
				rules: {
					validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"}
				},
				messages: {
					username: {required: "请填写用户名."},password: {required: "请填写密码."},
					validateCode: {remote: "验证码不正确.", required: "请填写验证码."}
				},
				errorLabelContainer: "#messageBox",
				errorPlacement: function(error, element) {
					error.appendTo($("#loginError").parent());
				} 
			});
		});
		
		function submit(){
			$("#loginForm").submit();
		}
		// 如果在框架或在对话框中，则弹出提示并跳转到首页
		if(self.frameElement && self.frameElement.tagName == "IFRAME" || $('#left').length > 0 || $('.jbox').length > 0){
			alert('未登录或登录超时。请重新登录，谢谢！');
			top.location = "${ctx}";
		}
	</script>
</head>
<body>
	<!--[if lte IE 6]><br/><div class='alert alert-block' style="text-align:left;padding-bottom:10px;"><a class="close" data-dismiss="alert">x</a><h4>温馨提示：</h4><p>你使用的浏览器版本过低。为了获得更好的浏览体验，我们强烈建议您 <a href="http://browsehappy.com" target="_blank">升级</a> 到最新版本的IE浏览器，或者使用较新版本的 Chrome、Firefox、Safari 等。</p></div><![endif]-->
	<img class="login-bg" src="${ctxStatic }/images/prms_bg.jpg">
	<div class="header">
	    <%-- <a href="#"><img src="${ctxStatic }/images/cq-air-logo.jpg"></a> --%>
	    <span class="sys-title">${fns:getConfig('productName')}</span>
	</div>
	<div class="login-main">
	    <div class="login-header">系统登录</div>
	    <div class="login-content">
	        <form id="loginForm" action="${ctx}/login" method="post">
	        <div class="input-wrap">
	            <input class="login-input required" placeholder="用户名"  id="username" name="username"  value="${username}">
	        </div>
	        <div class="input-wrap">
	            <input class="login-input required" type="password" placeholder="密码" id="password" name="password">
	        </div>
	        <div class="line-wrap">
	            <label class="remember-me"><input type="checkbox" id="rememberMe" name="rememberMe" ${rememberMe ? 'checked' : ''}>记住我</label>
	            <!--验证码-->
	            <div class="verify-wrap">
	            	<c:if test="${isValidateCodeLogin}"><div class="validateCode">
						<label class="input-label mid" for="validateCode">验证码</label>
						<sys:validateCode name="validateCode" inputCssStyle="margin-bottom:0;"/>
					</div></c:if>
	            </div>
	        </div>
	        </form>
	        <a class="login-submit" href="javascript:" onclick="submit()">登录</a>
	        <p id="messageBox" class="verify-info ${empty message ? 'hide' : ''}"><label id="loginError" class="error">${message}</label></p>
	    </div>
	</div>
</body>
</html>