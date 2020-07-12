<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <@n.navbar "${user.login}" />
    <div>
        <p>
        <h1>${user.login}</h1>
        <h3>Мои созданные курсы</h3>
        <a href="/user/add_course">Создать новый курс</a>
        <#list courses as course>
            <div>
                <p>
                    <a href="/user/edit/${course.id}">${course.name}</a>
                </p>
            </div>
        <#else>
            Нет курсов!
        </#list>
    </div>
</@c.page>