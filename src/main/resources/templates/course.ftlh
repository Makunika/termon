<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
<@n.navbar "${user.login}" />
    <div>
        <p>
        <h1>${course.name}</h1>
        <#list course.lessons as lesson >

            ${lesson.number}. <a href="/courses/lessons/${lesson.id}">${lesson.name}</a><br>

            <#else>
            Пока уроков нет
        </#list>
    </div>
</@c.page>