<#import "parts/common.ftl" as c>

<@c.page>

<header>
    <h3 xmlns:form="http://www.w3.org/1999/html">Редактируем инфо о киотеатре</h3>
    <input type="button" onclick="location.href='/point'" value="Home" />
    <input type="button" onclick="location.href='/point/#{point.id}/view'" value="Выйти из редактирования" />
</header>

<form action="/point" method="post">
    <table class="table">
    <tr>
        <td><b>Id</b></td>
        <td><input type="hidden" value="${point.id}" name="msgId"></td>
    </tr>
    <tr>
        <td><b>Тема</b></td>
        <td>
            <input type="text" name="subject" value="${point.subject}">
        </td>
    </tr>
    <tr>
        <td><b>Текст</b></td>
        <td>
        <input type="text" name="text" value="${point.text}">
        </td>
    </tr>
    </table>
    <button type="submit">Сохранить изменения</button>
</form>
</@c.page>
