<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <@n.navbar "username" />
    <form method="post">
        <p><input type="text" name="nameFilm" placeholder="Нзвание фильма"></p>
        <p><input type="text" name="urlPicter" placeholder="url каринки"></p>
        <p><input type="text" name="year" placeholder="Год"></p>
        <p><input type="submit" value="Отправить"></p>
    </form>
</@c.page>