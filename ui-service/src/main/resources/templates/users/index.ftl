<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Users</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<>
<main class="container">
  <div class="p-2">
    <table class="table">
      <thead class="thead-dark">
      <tr>
        <th scope="col">Name</th>
        <th scope="col">Photo</th>
      </tr>
      </thead>
      <tbody>
        <#if users??>
            <#list users as user>
                <tr>
                  <td scope="row">${user.name}</td>
                  <td>
                    <#if user.imageUrl?? >
                      <img src="${user.imageUrl}" class="img-responsive img-thumbnail">
                    </#if>
                  </td>
                </tr>
            </#list>
        </#if>
      </tbody>
    </table>
  </div>
</main>
</>
</html>