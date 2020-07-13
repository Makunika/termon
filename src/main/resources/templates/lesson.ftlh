<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <@n.navbar />
    <div>
        <p>${lesson.name}</p>
        <p>${lesson.text}</p>
        <p>${lesson.autor.login}</p>
    </div>
</@c.page>