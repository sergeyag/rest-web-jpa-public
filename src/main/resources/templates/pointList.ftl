<#import "parts/common.ftl" as c>

<@c.page>

<header>
    <h3 xmlns:form="http://www.w3.org/1999/html">Все кинотеатры</h3>
    <input type="button" onclick="location.href='/createNew'" value="Создать кино" />
    <input type="button" onclick="location.href='/load'" value="Загрузить данные с apidata.mos.ru" />
</header>

<div>
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">Id</th>
            <th>subject</th>
            <th>text</th>
            <th>Просмотр</th>
            <th>Правка</th>
        </tr>
        </thead>
        <tbody>
    <#list points as point>
    <tr>
        <td>${point.id}</td>
        <td>${point.subject}</td>
        <td>${point.text}</td>
        <td><a href="/point/#{point.id}/view">view</a></td>
        <td><a href="/point/#{point.id}/edit">edit</a></td>
    </tr>
    </#list>
        </tbody>
    </table>
</div>

</@c.page>
