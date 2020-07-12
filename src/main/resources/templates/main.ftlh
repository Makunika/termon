<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>
<#import "parts/login.ftlh" as l>
<@c.page>
    <@n.navbar "${user.login}" />

    <div>
        <a href="/user">Мой профиль</a>
        <@l.logout/>
    </div>

    <#list courses as course>
        <div>
            <p>
            <a href="/courses/${course.id}">${course.name}</a>
            </p>
        </div>
        <#else>
        Нет курсов!
    </#list>

</@c.page>