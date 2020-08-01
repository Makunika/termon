<#include "security.ftlh">

<#macro navbar>
    <!--<input type="hidden" name="_csrf" value="{_csrf.token}" />-->
    <header class="header">
        <div class="header_left">
            <div class="header_logo">
                <img src="/static/img/logo.png" alt="Логтипчик">
            </div>
            <nav class="header_links">
                <a href="/" class="header_link">Каталог курсов</a>
                <a href="/courses" class="header_link">Мои курсы</a>
                <#if isModer>
                <a href="/user" class="header_link">Мой профиль</a>
                    <#if isAdmin>
                <a href="/users_edit" class="header_link">Редактировать пользователей (для админа)</a>
                </#if>
                </#if>
            </nav>
        </div>
        <div class="header_right">
            <#if !isAnon>
            <p class="header_name">${name}</p>
            </#if>
            <#if isAnon >
            <a href="/login" class="header_in header_btn">Войти</a>
            <form action="/registration" method="GET">

                <button type="submit" class="header_reg header_btn">Регистрация</button>
            </form>
            <#else>
            <form action="/logout" method="post">
                <button type="submit" class="header_out header_btn">Выйти</button>
            </form>
            </#if>
        </div>
    </header>
</#macro>