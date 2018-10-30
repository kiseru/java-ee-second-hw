<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Sign Up</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
</head>
<body class="bg-light">
  <main class="container">
    <div class="p-3">
      <div class="bg-white rounded shadow">
        <div class="p-3">
          <form id="sign-up-form" action="/sign_up" method="post">
            <div class="form-group">
              <label for="name">Name</label>
              <input class="form-control" type="text" id="name" name="name"/>
            </div>

            <input type="hidden" id="uuid" name="uuid" value=""/>

            <button class="btn btn-lg btn-block" id="submit-button">Sign Up</button>
          </form>
        </div>
      </div>
    </div>
  </main>

  <script src="/script.js"></script>

</body>
</html>