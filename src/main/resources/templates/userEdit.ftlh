<#import "parts/common.ftlh" as c>

<@c.page>
    User editor

    <form action="/users_edit/${user.id}" method="post">
        <input type="text" name="username" value="${user.login}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <button type="submit">Save</button>
    </form>
</@c.page>