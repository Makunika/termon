<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>
<@c.page>
    <link rel="stylesheet" href="/static/css/style_main.css">
    <@n.navbar />
    <div class="content">
        <h2 id="header_courses">Какие курсы у нас есть</h2>
        <div class="cards_courses">
            <#list courses as course>

                <#if course?is_odd_item>
                    <div class="row">
                </#if>

                <div class="column">
                    <a href="/course/${course.id}">
                        <div class="card_course">
                            <div class="card_course_img">
                                <img src="/img/${course.headerImgName}" alt="Логотип Курса">
                            </div>
                            <div class="card_course_texts">
                                <div class="name_course">
                                    <p>${course.name}</p>
                                </div>
                                <div class="about_course">
                                    <p>${course.about}</p>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <#if course?is_even_item || course?is_last>
                    </div>
                </#if>


            </#list>
        </div>
    </div>

</@c.page>