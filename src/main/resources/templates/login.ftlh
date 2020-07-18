<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>

<@c.page>
    <@n.navbar />
    <form action="/login" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Войти"/></div>
    </form>
</@c.page>