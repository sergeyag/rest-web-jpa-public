<#import "parts/common.ftl" as c>

<@c.page>

<header>
    <h3 xmlns:form="http://www.w3.org/1999/html">Новый кинотеатр</h3>
    <input type="button" onclick="location.href='/point'" value="Закрыть без сохранения" />
</header>

<form action="/point" method="post">
    <table class="table">
    <tr>
        <td><b>Id</b></td>
        <td><input type="hidden" name="msgId"></td>
    </tr>
    <tr>
        <td><b>Тема</b></td>
        <td>
            <input type="text" name="subject">
        </td>
    </tr>
    <tr>
        <td><b>Текст</b></td>
        <td>
        <input type="text" name="text">
        </td>
    </tr>
    </table>
    <button type="submit">Сохранить изменения</button>
</form>
</@c.page>
