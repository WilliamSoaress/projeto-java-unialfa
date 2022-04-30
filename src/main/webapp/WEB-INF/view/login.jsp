<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Vehicle Locator - Login</title>
</head>
<body class="text-light">
    <div class="conteudo mx-auto">
        <h1 class="bg-dark rounded my-3 p-3 fs-3 text-center">Vehicle Locator</h1>

        <form method="post" action="/home">
            <div class="mb-3">
              <input type="text" class="form-control" name="login" placeholder="Login" required>
            </div>
            <div class="mb-3">
              <input type="password" class="form-control" name="senha" placeholder="Senha" required>
            </div>
            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-success">Entrar</button>
            </div>
          </form>

          <small class="d-block mt-4 text-muted">
            Usuário padrão: user <br>
            Senha padrão: 123
          </small>
    </div>    
</body>
</html>