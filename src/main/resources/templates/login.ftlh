<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>

<@c.page>
    <@n.navbar />
    <link rel="stylesheet" href="/static/css/style_login.css">
    <div class="content">
        <form action="/login" method="post" class="ui-form">
            <h3>Войти</h3>
            <div class="form-row">
                <input type="text" id="login" name="username" required autocomplete="off">
                <label for="login">Логин</label>
            </div>
            <div class="form-row">
                <input type="password" id="password" name="password" required autocomplete="off">
                <label for="password">Пароль</label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="btn"><input type="submit" value="Войти"/></div>
            <div class="registration">
                <a href="/registration">Регистрация</a>
            </div>
        </form>
    </div>
</@c.page>