<#macro listReview>
    <form method="post">
        <p><input type="text" name="username" placeholder="username"></p>
        <p><input type="text" name="name" placeholder="Название"></p>
        <p><textarea typeof="text" name="text" placeholder="Текст"></textarea></p>
        <p><input type="submit" value="Отправить"></p>
    </form>

    <#list reviews as review>
        <div>
            <p><h3>${review.username}</h3></p>
            <p><h1>${review.reviewName}</h1></p>
            <p><div>${review.textReview}</div></p>
        </div>
        <#else>
            <div>
                Пока нет отзывов на этот фильм, станьте первыми :)
            </div>
    </#list>
</#macro>