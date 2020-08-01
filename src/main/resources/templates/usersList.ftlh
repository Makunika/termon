<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <@n.navbar />
    <form action="/users_edit" method="post">
        <input type="text" placeholder="login"/>
        <button type="submit">Найти</button>
    </form>


    <table>
        <thead>
        <tr>
            
            <th>Login</th>
            <th>Roles</th>
            <th>Button</th>
        </tr>
        </thead>
        <tbody>
            <#list users as user>
                <tr>
                    <td>${user.login! "Имя null (Проверить в дб)"}</td>
                    <td><#list user.roles as role>${role}<#sep>, <#else> null (Проверить в дб)</#list></td>
                    <td><a href="/users_edit/${user.id}">Изменить</a></td>
                </tr>
                <#else>
                Никто не найден!
            </#list>
        </tbody>
    </table>
    </div>
</@c.page>