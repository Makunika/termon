<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getLogin()
    isAdmin = user.isAdmin()
    isModer = user.isModer()
    isAnon = false
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isModer = false
    isAnon = true
    >
</#if>