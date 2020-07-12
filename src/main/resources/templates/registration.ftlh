<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>

<@c.page>
    <@n.navbar "Пока ничего" />
    <form action="/registration" method="post">
        <div><label> User Name : <input type="text" name="login"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Регистрация"/></div>
    </form>
    <br>
    ${error!}
</@c.page>