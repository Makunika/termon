<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>
<#import "parts/login.ftlh" as l>
<@c.page>
    <@n.navbar "" />

    <form action="/courses" method="get">
        <button type="submit">Мои курсы</button>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
    </form>
    <form action="/registration" method="get">
        <button type="submit">Регистрация</button>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
    </form>

    <h3>Какие курсы у нас есть</h3>

    <#list courses as course>
        <div>
            <p>
                ${course.name}
            </p>
        </div>
    <#else>
        Нет курсов!
    </#list>

</@c.page>