<!DOCTYPE html>
<html lang='ja'>
<body>
<h2>
    Add User
</h2>
<form method='post' action='/add-user'>
    <p><label for='id'>ID: </label>
        <input type='text' name='id'></p>
    <p><label for='name'>NAME: </label>
        <input type='text' name='name'></p>
    <input type='submit' value='送信'>
</form>
<p><a href='/users'>See All Users</a></p>
</body>
</html>