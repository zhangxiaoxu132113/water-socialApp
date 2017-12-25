<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/7/18
  Time: 下午10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <style>
        .bread {
            padding:1em 0;
        }
    </style>
    <link rel="stylesheet" href="<%=path%>/asset/css/blog-category.css">
    <jsp:include page="../common/baidu_statistics_code.jsp"/>
</head>
<body>
    <div id="container">
        <div id="header">
            <div id="header-inner">
                <div class="header-nav">
                    <div class="header-nav-inner">
                        <ul>
                            <li>首页</li>
                            <li>文档库</li>
                            <li>资讯</li>
                            <li>IT教程</li>
                            <li>知识库</li>
                            <li>知识库</li>
                        </ul>
                    </div>
                </div>
                <div class="header-user">
                    <div class="header-user-inner">
                        <ul>
                            <li><a href="/login">登录</a></li>
                            <li><a href="/user/register">注册</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="main-content">
            <div class="bread">
                <span>首页</span> > <span>文档库</span> > <span>前端知识</span>
            </div>
            <div id="article-list">
                <div class="page-info">
                    第 <span class="begin">1</span>- <span class="end">100</span> 条，共 <span class="totalItem">1288</span> 条| <a href="">下一页</a>
                    <p><span>显示内容简介</span>&nbsp;|&nbsp;<span><a href="">隐藏内容简介</a></span></p>
                </div>

                <table class="article-list-table">
                    <tr>
                        <th>题目</th>
                        <th>类别</th>
                        <th>日期</th>
                    </tr>
                    <tr>
                        <td>
                            <h4 class="article-title">有效使用 Node.js 事件循环</h4>
                            <p class="article-intro">
                                对于 Node.js 应用程序开发新手而言，作为学习曲线的一部分，
                                他们需要了解单线程事件循环的工作原理，以及它可能导致意外结果的方式。
                                您可以使用本教程中的 3 个交互式示例中的事件循环进行练习。
                                您很快就能编写快速、高效的代码来轻松处理异步调用。
                            </p>
                        </td>
                        <td>
                            <span class="article-category">Python</span>
                        </td>
                        <td>
                            <span>2017年 06月 27日</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4 class="article-title">有效使用 Node.js 事件循环</h4>
                            <p class="article-intro">
                                对于 Node.js 应用程序开发新手而言，作为学习曲线的一部分，
                                他们需要了解单线程事件循环的工作原理，以及它可能导致意外结果的方式。
                                您可以使用本教程中的 3 个交互式示例中的事件循环进行练习。
                                您很快就能编写快速、高效的代码来轻松处理异步调用。
                            </p>
                        </td>
                        <td>
                            <span class="article-category">Java</span>
                        </td>
                        <td>
                            <span>2017年 06月 27日</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4 class="article-title">有效使用 Node.js 事件循环</h4>
                            <p class="article-intro">
                                对于 Node.js 应用程序开发新手而言，作为学习曲线的一部分，
                                他们需要了解单线程事件循环的工作原理，以及它可能导致意外结果的方式。
                                您可以使用本教程中的 3 个交互式示例中的事件循环进行练习。
                                您很快就能编写快速、高效的代码来轻松处理异步调用。
                            </p>
                        </td>
                        <td>
                            <span class="article-category">Python</span>
                        </td>
                        <td>
                            <span>2017年 06月 27日</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4 class="article-title">有效使用 Node.js 事件循环</h4>
                            <p class="article-intro">
                                对于 Node.js 应用程序开发新手而言，作为学习曲线的一部分，
                                他们需要了解单线程事件循环的工作原理，以及它可能导致意外结果的方式。
                                您可以使用本教程中的 3 个交互式示例中的事件循环进行练习。
                                您很快就能编写快速、高效的代码来轻松处理异步调用。
                            </p>
                        </td>
                        <td>
                            <span class="article-category">Python</span>
                        </td>
                        <td>
                            <span>2017年 06月 27日</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4 class="article-title">有效使用 Node.js 事件循环</h4>
                            <p class="article-intro">
                                对于 Node.js 应用程序开发新手而言，作为学习曲线的一部分，
                                他们需要了解单线程事件循环的工作原理，以及它可能导致意外结果的方式。
                                您可以使用本教程中的 3 个交互式示例中的事件循环进行练习。
                                您很快就能编写快速、高效的代码来轻松处理异步调用。
                            </p>
                        </td>
                        <td>
                            <span class="article-category">Python</span>
                        </td>
                        <td>
                            <span>2017年 06月 27日</span>
                        </td>
                    </tr>
                </table>
            </div>
        </div>

    </div>
</body>
</html>
