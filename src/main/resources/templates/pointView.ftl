<#import "parts/common.ftl" as c>

<@c.page>

<header>
    <h3>Просмотр кинотеатра</h3>
    <input type="button" onclick="location.href='/point'" value="Home" />
    <input type="button" onclick="location.href='/point/#{point.id}/edit'" value="Редактировать" />
</header>

<form action="/point" method="post">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th>Название</th>
            <th>Значение</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Id</td>
            <td>${point.id}</td>
        </tr>
        <tr>
            <td>Название</td>
            <td>${point.subject}</td>
        </tr>

        <tr>
            <td>Адрес</td>
            <td>${point.text}</td>
        </tr>

        </tbody>
    </table>
</form>

</@c.page>
