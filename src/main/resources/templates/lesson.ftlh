<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <@n.navbar />
    <div>
        <p>${lesson.name}</p>
        <p>${lesson.text}</p>
        <p>${lesson.autor.login}</p>
    </div>

    <div>
        <form action="/courses/lessons/${lesson.id}" method="post">
            <textarea name="ans" placeholder="Ваш ответ на это">${answer!""}</textarea>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <#if ansExist>
                <input type="hidden" value="edit" name="type">
                <button type="submit">Редактировать ответ</button>
                <#else>
                    <input type="hidden" value="add" name="type">
                    <button type="submit">Отправить ответ</button>
            </#if>
        </form>
        <#if ansExist>
            <form action="/courses/lessons/${lesson.id}" method="post">
                <input type="hidden" value="delete" name="type">
                <button type="submit">Удалить весь ответ</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
            </form>
        </#if>
    </div>
</@c.page>