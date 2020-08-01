<#import "parts/common.ftlh" as c>
<#import "parts/navbar.ftlh" as n>


<@c.page>
    <link rel="stylesheet" href="/static/css/style_edit_course.css">
    <link rel="stylesheet"
          href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.1.2/styles/androidstudio.min.css">
    <@n.navbar />
    <div class="content__">
        <div class="tabs">
            <div class="tabs_links">
                <!--<button class="btn_blue active_link">Вкладка 1</button>
                <button class="btn_blue">Вкладка 2</button>
                <button class="btn_blue">Вкладка 3</button>-->
                <button class="btn_blue">+</button>
            </div>
            <div class="tabs_contents">
                <!--<div class="tabs_content show_flex">
                    <div class="tabs_flex_column mark">
                        <h2>Markdown</h2>
                        <textarea class="mark_textarea">
                        </textarea>
                    </div>
                    <div class="tabs_flex_column review">
                        <h2>Review</h2>
                        <div class="review_content"></div>
                    </div>
                </div>
                <div class="tabs_content hide">
                    <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa
                        metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada,
                        metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem.
                        Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing
                        adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere
                        viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
                        pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis.
                        Mauris consectetur tortor et purus.</p>
                </div>
                <div class="tabs_content hide">
                    <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel
                        vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non
                        ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos
                        himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus
                        hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a,
                        lacus.</p>
                    <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac
                        lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing
                        velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus
                        eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis
                        commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede.
                        Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit.
                        Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
                </div>-->
            </div>
        </div>
    </div>
    <script src="/static/js/edit_course.js"></script>
</@c.page>