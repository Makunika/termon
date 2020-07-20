<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>

<@c.page>
    <@n.navbar />
    <link rel="stylesheet" href="/static/css/style_login.css">
    <div class="content">
        <form action="/registration" method="post" class="ui-form">
            <h3>Регистрация</h3>
            <div class="form-row">
                <input type="text" id="email" name="email" required autocomplete="off">
                <label for="email">Email</label>
            </div>
            <div class="form-row">
                <input type="text" id="login" name="username" required autocomplete="off">
                <label for="login">Логин</label>
            </div>
            <div class="form-row">
                <input type="password" id="password" name="password" required autocomplete="off">
                <label for="password">Пароль</label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="btn"><input type="submit" value="Регистрация"/></div>
            <div class="registration">
                <a href="/login">Уже есть аккаунт? Войти</a>
            </div>
        </form>
    </div>
    <br>
    ${error!}
</@c.page>