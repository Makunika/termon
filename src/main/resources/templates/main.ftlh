<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>

<@c.page>
    <@n.navbar "${user}" />

    <div><a href="/add">Добавить фильм</a></div>

    <#list films as film>
        <div>
            <p><img src="${film.url}" alt="Нет картинки у фильма"></p>
            <p>
            <a href="/film/${film.id}">${film.name}</a>
            </p>
        </div>
        <#else>
        Нет Фильмов
    </#list>

</@c.page>