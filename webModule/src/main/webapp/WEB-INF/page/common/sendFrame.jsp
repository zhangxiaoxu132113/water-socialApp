<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/2/1
  Time: 下午5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link rel="stylesheet" type="text/css" href="<%=path%>/plugs/sweet-alert/css/sweet-alert.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/asset/css/sendFrame.css">
<div class="mw-popup" style="display: none">
    <div class="mw-popup-inner">
        <a class="closeBtn"><i class="iconfont" style="font-size: 14px">&#xe659;</i></a>
        <h4>心情物语</h4>

        <div class="moon-content" style="outline: none" contenteditable="true"></div>
        <div class="moon-toolbar">
            <a class="addPhoto"><i class="iconfont">&#xe780;</i></a>
            <!-- 隐藏的文件上传的input表单 -->
            <form action="/upload/imageList" id="uploadMultiFiles" method="post" enctype="multipart/form-data">
                <input type="file" name="file" class="uploadFiles mw-hidden">
            </form>
            <iframe name="hidden_frame" id="hidden_frame" class="hidden_frame"></iframe>
            <a class="addLocaltion"><i class="iconfont">&#xe768;</i></a>
            <a class="addMusic"><i class="iconfont" style="font-size: 25px">&#xe624;</i></a>
            <a class="sendContBtn"><i class="iconfont">&#xe6b0;</i>发送</a>
            <span class="limitNumber">135</span>

            <div style="clear: both"></div>
        </div>
        <div class="add-content">
            <em></em>

            <div class="added-img-list">
                    <span class="addImageBtn">
                      <i class="iconfont">&#xe6ea;</i>
                    </span>
            </div>
        </div>
    </div>
</div>

<script src="<%=path%>/plugs/sweet-alert/js/sweet-alert.min.js"></script>
<script src="<%=path%>/asset/js/sendFrame.js"></script>
<script src="<%=path%>/plugs/mrwater/mw-upload.js"></script>