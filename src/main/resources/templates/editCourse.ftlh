<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <@n.navbar />
    <div>
        <p>
        <h1>${course.name}</h1>
        <ul>
        <#list course.lessons as lesson >

            <li><a href="/courses/lessons/${lesson.id}">${lesson.name}</a></li>

        <#else>
            Пока уроков нет
        </#list>
        </ul>
    </div>

    <form action="/user/edit/${course.id}" method="post">
        <label><input type="text" placeholder="Название урока" name="name"></label>
        <label><input type="text" placeholder="Текст урока" name="text"></label>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Создать урок</button>
    </form>
</@c.page>