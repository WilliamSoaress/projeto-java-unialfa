<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Vehicle Locator - Cadastrar Veículo</title>
</head>

<body class="text-light">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="/home" id="navTitle">Vehicle Locator</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Cadastros
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><a class="dropdown-item" href="/cliente/cadastrar">Cadastrar Cliente</a></li>
                        <li><a class="dropdown-item" href="/veiculo/cadastrar">Cadastrar Veículo</a></li>
                        <li><a class="dropdown-item" href="/usuario/cadastrar">Cadastrar Funcionário</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Operaçoes
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><a class="dropdown-item" href="/veiculo/alugar">Alugar Veículo</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Relatórios
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><a class="dropdown-item" href="/cliente/relatorio">Relatório de Clientes</a></li>
                        <li><a class="dropdown-item" href="/veiculo/relatorio">Relatório de Veículos</a></li>
                        <li><a class="dropdown-item" href="/usuario/relatorio">Relatório de Funcionários</a></li>
                        <li><a class="dropdown-item" href="/aluguel/relatorio">Relatório de Locações</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
    <div class="conteudo mx-auto bg-dark">
        <h1 class="bg-dark rounded my-3 p-3 fs-3 text-center">Cadastro de Veículos</h1>
        <hr class="bg-secondary">
        <form method="post" action="/veiculo/cadastrado">
            <h2 class="mb-3">Cadastrar Veículo</h2>
            <div>
                <input type="hidden" name="id" value="${veiculo.id}"/>
            </div>
            <div class="mb-3">
                <input type="text" class="form-control" name="modelo" value="${veiculo.modelo}" placeholder="Modelo" required>
            </div>
            <div class="mb-3">
                <input type="text" class="form-control" name="fabricante" value="${veiculo.fabricante}" placeholder="Fabricante" required>
            </div>
            <div class="mb-3">
                <input type="text" class="form-control" name="ano" value="${veiculo.ano}" placeholder="Ano" required>
            </div>
            <div class="mb-3">
                <input type="text" class="form-control" name="cor" value="${veiculo.cor}" placeholder="Cor" required>
            </div>
            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-success">Salvar Veículo</button>
            </div>
        </form>        
    </div>
</body>

</html>