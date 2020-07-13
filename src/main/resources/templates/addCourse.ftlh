<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <@n.navbar />
    <form action="/user/add_course" method="post">
        <p><input type="text" name="nameCourse" placeholder="Название Курса"></p>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <p><button type="submit">Создать</button></p>
    </form>
</@c.page>