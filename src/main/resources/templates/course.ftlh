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
    <link rel="stylesheet" href="/static/css/style_course.css">
    <div class="content">
        <div class="wrapper">
            <div class="row">
                <div class="column column_text">
                    <h4>${course.name}</h4>
                    <p class="about">${course.about}</p>
                    <#if isAnon>
                    <a href="/login" class="btn_course_start">Для записи необходимо войти в аккаунт</a>
                    <#elseif isSub>
                    <form action="/course/${course.id}" method="post">
                        <input type="hidden" value="unsub" name="type">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn_course_start transperent">Отписаться</button>
                    </form>
                    <#else>
                     <form action="/course/${course.id}" method="post">
                        <input type="hidden" value="sub" name="type">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn_course_start transperent">Подписаться</button>
                     </form>
                     </#if>
                </div>
                <div class="column column_img">
                    <div class="img_course">
                        <img src="/img/${course.headerImgName}" alt="Логотип курса">
                    </div>
                </div>
            </div>
        </div>

        <#if isSub>
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