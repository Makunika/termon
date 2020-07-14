<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>
<#include "parts/security.ftlh">

<#if isAnon>
    <#assign
    isSub = false
    >
    <#else>
        <#assign
        isSub = user.isSub(course)
        >
</#if>



<@c.page>
<@n.navbar />
    <div>
        <p>
        <h1>${course.name}</h1>

        <#if isAnon>
            Для записи необходимо зарегаться
            <#elseif isSub>
                <form action="/course/${course.id}" method="post">
                    <input type="hidden" value="unsub" name="type">
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <button type="submit">Отписаться</button>
                </form>

                <form action="/course/${course.id}">
                    <input type="hidden" value="unsub">
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <button type="submit"></button>
                </form>
                <div class="spoiler">
                    <label>
                        <input type="checkbox"/>
                        <span class="btn">Посмотреть список уроков</span>
                        <div class="text">
                            <#list course.lessons as lesson >
                                <a href="/courses/lessons/${lesson.id}">${lesson.name}</a><br>
                            <#else>
                                Пока уроков нет
                            </#list>
                        </div>
                    </label>
                </div>


            <#else>
            <form action="/course/${course.id}" method="post">
                <input type="hidden" value="sub" name="type">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <button type="submit">Подписаться</button>
            </form>
        </#if>
    </div>





    <style>
        .spoiler {
            display: block;
        }

        .btn {
            display: inline-block;
            border: none;
            border-radius: 4px;
            font-size: 22px;
            padding: 10px 20px;
            background: #558ed6;
            color: #fff;
            font-family: Tahoma, sans-serif;
            cursor: pointer;
        }

        .spoiler input[type=checkbox] {
            display: none;
        }

        .text {
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin: 12px 0 20px;
        }

        .spoiler input[type=checkbox] ~ .text {
            display: none;
        }

        .spoiler input[type=checkbox]:checked ~ .text {
            display: block;
        }
    </style>
</@c.page>