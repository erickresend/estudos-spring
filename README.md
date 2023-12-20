# MEUS ESTUDOS DO SPRING FRAMEWORK

### parking-control
- Nesse mini curso foi feito uma API para controle de vagas de estacionamento de um condomínio. [Vídeo](https://www.youtube.com/watch?v=LXRU-Z36GEU)
- [x] Criamos model e repository para criar a tabela no banco de dados postgreSQL.
- [x] Criamos service e controller para criar os endpoints.
- [x] CRUD das vagas com resposta no status correto da requisição seguindo o padrão REST.
- [x] Criamos o Dto para fazer algumas validações.
- [x] Tudo testado no postman

- Nessa continuação do curso ela estava usando uma versão do spring security inferior a minha, então boa parte da implementação eu precisei buscar em outras fontes e fui seguindo com ela o raciocínio. [vídeo](https://www.youtube.com/watch?v=t6prPki7daU&t=6932s)
- [x] Criamos uma classe de segurança para restringir o acesso apenas a pessoas autenticadas.
- [x] Criamos uma entidade de usuário e função e alguns exemplos direto no banco para teste.
- [x] Restringimos os endpoints por níveis de autorização.
- [x] Tudo testado no postman

- [x] No curso não teve endpoints para criação de usuários e listagem de funções, então implementei sozinho para deixar a API mais completa.
