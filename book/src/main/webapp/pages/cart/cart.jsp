<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>购物车</title>

        <%--静态包含 base标签、css样式、jQuery文件--%>
        <%@include file="/pages/common/head.jsp" %>

        <script>
            $(function () {
                //给 删除 绑定单击事件
                $("a.deleteItem").click(function () {
                    return confirm("你确定要删除《" + $(this).parent().parent().find("td:first").text() + "》吗？");
                });
                //给 清空购物车 绑定单击事件
                $("#clearItem").click(function () {
                    return confirm("你确定要清空购物车吗？");
                });
                //给 数量输入框 绑定onchange事件
                $("input.itemCount").change(function () {
                    //获取书名
                    var name = $(this).parent().parent().find("td:first").text();
                    //获取数量
                    var count = this.value;
                    if (confirm("您确定把《" + name + "》数量改为" + count + "吗？")) {
                        //获取id
                        var id = $(this).attr("bookId");
                        location.href = "http://localhost:8080/book/cartServlet?action=updateCount&id=" + id + "&count=" + count;
                    } else {
                        this.value = this.defaultValue;
                    }
                })
            })
        </script>

    </head>
    <body>

        <div id="header">
            <img class="logo_img" alt="" src="static/img/logo.gif">
            <span class="wel_word">购物车</span>

            <%--静态包含，登陆成功之后的菜单--%>
            <%@ include file="/pages/common/login_success_menu.jsp" %>

        </div>

        <div id="main">

            <table>
                <c:if test="${not empty sessionScope.cart.items}">
                    <tr>
                        <td>商品名称</td>
                        <td>数量</td>
                        <td>单价</td>
                        <td>金额</td>
                        <td>操作</td>
                    </tr>
                </c:if>
                <c:if test="${empty sessionScope.cart.items}">
                    <tr>
                        <td colspan="5"><a href="index.jsp">当前购物车为空，请添加商品</a></td>
                    </tr>

                </c:if>

                <c:forEach items="${sessionScope.cart.items}" var="cartItem">
                    <tr>
                        <td>${cartItem.value.name}</td>
                        <td>
                            <input type="text" class="itemCount" style="width: 80px; text-align: center"
                                   value="${cartItem.value.count}" bookId="${cartItem.value.id}">
                        </td>
                        <td>${cartItem.value.price}</td>
                        <td>${cartItem.value.totalPrice}</td>
                        <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${cartItem.value.id}">删除</a></td>
                    </tr>
                </c:forEach>

            </table>

            <c:if test="${not empty sessionScope.cart.items}">
                <div class="cart_info">
                    <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
                    <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
                    <span class="cart_span"><a id=clearItem href="cartServlet?action=clearItem">清空购物车</a></span>
                    <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
                </div>
            </c:if>

        </div>

        <%--静态包含页脚内容--%>
        <%@include file="/pages/common/footer.jsp"%>
    </body>
</html>