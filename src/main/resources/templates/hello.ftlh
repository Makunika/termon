<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>
<#import "parts/login.ftlh" as l>
<@c.page>
    <@n.navbar />

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