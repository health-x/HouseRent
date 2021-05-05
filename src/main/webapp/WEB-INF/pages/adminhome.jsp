<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/admin.css">
    <style>
        .center{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <a href="welcome01" target="iframe">
            <div class="layui-logo">
                <h2>管理员中心</h2>
            </div>
        </a>
        <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
            <li class="layui-nav-item center" lay-unselect="">
                <a href="javascript:;">
                    <cite>Hello，管理员</cite>
                    <span class="layui-nav-more"></span></a>
                <dl class="layui-nav-child layui-anim layui-anim-upbit">
                    <dd><a href="toUpdateAdminPwdPage">修改密码</a></dd>
                    <dd style="text-align: center;"><a href="adminSingnout">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div class="layui-side">
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item">
                <a href="javascript:;">用户信息管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath }/toAllUserPage" target="iframe">查看所有用户</a></dd>
                    <dd><a href="${pageContext.request.contextPath }/toUpdateAdminPwdPage" target="iframe">管理员密码更改</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item">
                <a href="javascript:;">房源信息管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath }/toAllHousePage" target="iframe">所有房源信息</a></dd>
                    <dd><a href="${pageContext.request.contextPath }/addHouse" target="iframe">添加房源信息</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div class="layui-body">
        <iframe src="${pageContext.request.contextPath }/welcome01" width="100%" height="100%" frameborder="0" name="iframe" scrolling="auto" seamless></iframe>
    </div>
    <footer class="layui-footer" style="text-align: center;font-size: 16px">

    </footer>
</div>
<script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element'], function () {
        var element = layui.element,
            $ = layui.jquery;
    });
</script>
</body>
</html>
