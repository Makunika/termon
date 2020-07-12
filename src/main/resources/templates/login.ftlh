<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>
<#import "parts/login.ftlh" as l>

<@c.page>
    <@n.navbar "Ничего" />
    <@l.login "/login" />
    <a href="/registration">Регистрация</a>
</@c.page>