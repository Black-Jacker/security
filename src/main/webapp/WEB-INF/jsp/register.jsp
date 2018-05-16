<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册用户</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div style="width:400px;height:600px;margin: 60px auto;">
    <h3>注册用户</h3>
    <form method="post" action="/register">
        <div class="input-group">
            <label>邮箱：</label>
            <input type="email" name="email" class="form-control" placeholder="email" aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="input-group">
            <label>昵称：</label>
            <input type="password" name="password" class="form-control" placeholder="password" aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="input-group">
            <label>密码：</label>
            <input type="password" name="password" class="form-control" placeholder="password" aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="input-group">
            <label>确认密码：</label>
            <input type="password" name="password" class="form-control" placeholder="password" aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="input-group">
            <label>手机号码：</label>
            <input type="password" name="password" class="form-control" placeholder="password" aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="input-group">
            <input type="submit"  class="btn btn-default" value="登录">
        </div>
    </form>
</div>

<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>