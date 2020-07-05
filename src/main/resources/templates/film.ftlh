<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>
<#import "parts/reviewList.ftlh" as l>


<@c.page>
<@n.navbar "username" />
    <div>
        <img src="${film.url}" alt="Нет картинки">
        <p>
        <h1>${film.name}</h1>
        </p>
        <p>
        <h3>${film.name}</h3>
        </p>
        <p>
        <div>${film.year}</div>
        </p>
    </div>

<@l.listReview/>
</@c.page>