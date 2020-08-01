<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <@n.navbar />
    <form action="/user/add_course" method="post" enctype="multipart/form-data">
        <p><input type="text" name="nameCourse" placeholder="Название Курса"></p>
        <input type="file" name="file" placeholder="Картинка курса">
        <textarea name="aboutCourse" placeholder="Немного о курсе" ></textarea>
        <p><button type="submit">Создать</button></p>
    </form>
</@c.page>