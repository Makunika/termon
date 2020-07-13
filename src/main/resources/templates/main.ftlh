<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>
<#import "parts/login.ftlh" as l>
<@c.page>
    <@n.navbar />

    <div>Курсы, на которые я подписан</div>

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