# DayToday

Uma API para o sistema de controle de rotinas pessoais.

## Endpoints
- Metas
    - [Cadastrar](#cadastrar-meta)
    - Listar todas
    - Apagar
    - Alterar
    - [Mostrar a descrição](#detalhar-descrição)
- Contas
    - Cadastrar
    - Listar todas
    - Apagar
    - Alterar
    - Mostrar os detalhes


---

### Cadastrar meta
`POST` /DayToday/api/metas

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| nome_id | int | sim | é o id do nome do usuário
| categoria_id | int | sim | é o id de uma categoria previamente cadastrada
| descricao | texto | não | é o id de uma conta previamente cadastrada

**Exemplo de corpo do request**

```js
{
    "nome_id": 1,
    "categoria_id": 1,
    "descricao": "cinema com os amigos"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 201 | despesa cadastrada com sucesso
| 400 | erro na validação dos dados da requisição

---

### Detalhar descrição
`GET` /DayToday/api/descrição/{id}

**Exemplo de corpo da resposta**

```js
{
    
    "nome": {
        "nome_id": 1,
        "nome": "Ler 30 páginas"
    }
    "tipo": {
        "tipoMeta_id" : 1,
        "tipo": "Meta Diária"
    }
    
    "descricao": "a meta é ler algum livro diáriamente para se acostumar com o hábito da leitura"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados retornados no corpo da resposta
| 404 | não foi possivel criar rotina, pois ela está indisponivel, ou já existe
