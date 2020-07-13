<#include "security.ftlh">
<#import "login.ftlh" as l>

<#macro navbar>
    <h3>navbar ${name} </h3>
    <form action="/" method="get">
        <button type="submit">Главная</button>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
    </form>

    <#if isAnon >
        <form action="/registration" method="get">
            <button type="submit">Регистрация</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </form>
        <form action="/login" method="get">
            <button type="submit">Войти</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </form>

        <#else >
            <#if isModer>
                <form action="/user" method="get">
                    <button type="submit">Мой профиль (для админа или модератора)</button>
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                </form>
            </#if>

            <#if isAdmin>
                <form action="/user" method="get">
                    <button type="submit">Мой профиль (для админа или модератора)</button>
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                </form>
                <a href="/users_edit">Редактировать пользователя (для админа)</a>
            </#if>

            <form action="/courses" method="get">
                <button type="submit">Мои курсы</button>
                <input type="hidden" value="${_csrf.token}" name="_csrf">
            </form>
            <@l.logout />
    </#if>
</#macro>