<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <@n.navbar />
    <link rel="stylesheet" href="/static/css/style_edit_modules.css">
    <div class="content__">
        <div class="programm_back">
            <div class="programm content">
                <div class="programm_item">
                    <header class="header_programm">
                        <h3>${course.name}</h3>
                    </header>
                    <ul class="content_programm">
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <script src="/static/js/edit_modules.js"></script>
</@c.page>