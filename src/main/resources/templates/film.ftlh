<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>
<#import "parts/reviewList.ftlh" as l>


<@c.page>
<@n.navbar "username" />
    <#if film??>
        <div>
            <img src="${url}" alt="Нет картинки">
            <p>
            <h1>${film.name}</h1>
            </p>
            <p>
            <h3>${film.nameEng}</h3>
            </p>
            <p>
            <div>${film.year}</div>
            </p>
        </div>
        <#else>
        Ошибка!
    </#if>

<@l.listReview "${reviews}"/>
</@c.page>