# Aplicativo Android Kotlin - README

<img src="gif\tmdb.gif" width="200" height="400" alt="Exemplo de GIF">

Este é um aplicativo Android Kotlin desenvolvido utilizando a arquitetura MVVM (Model-View-ViewModel). O aplicativo é baseado no conceito do TMDB (The Movie Database) e oferece funcionalidades para visualizar e atualizar filmes, programas de TV e artistas. Ele utiliza várias tecnologias e bibliotecas para aprimorar sua funcionalidade e manter uma estrutura modular. Este README fornece uma visão geral das tecnologias utilizadas neste projeto.

## Tecnologias Utilizadas

### Retrofit
[Retrofit](https://square.github.io/retrofit/) é uma biblioteca cliente HTTP tipo-safe para Android e Java. Ela simplifica o processo de fazer requisições de rede, abstraindo as chamadas de rede subjacentes e fornecendo uma API fácil de usar para definir endpoints e manipular respostas. Retrofit é usado neste projeto para interagir com APIs RESTful.

### Room
[Room](https://developer.android.com/topic/libraries/architecture/room) é uma biblioteca de mapeamento de objetos SQLite que fornece uma camada de abstração sobre as interações diretas com o banco de dados SQLite. Ela oferece verificação em tempo de compilação de consultas SQL, acesso conveniente aos dados e transações de banco de dados simplificadas. Room é usado para fornecer um banco de dados local para armazenar e recuperar dados de maneira estruturada.

### Dagger 2
[Dagger 2](https://dagger.dev/) é uma biblioteca de injeção de dependência que simplifica a forma como as dependências são gerenciadas em um aplicativo. Ela permite a criação de componentes e a injeção automática de dependências, melhorando a modularidade e a testabilidade do código. Dagger 2 é usado neste projeto para gerenciar a injeção de dependências e fornecer uma estrutura escalável.

### Glide
[Glide](https://bumptech.github.io/glide/) é uma biblioteca eficiente de carregamento e exibição de imagens para Android. Ela permite o carregamento assíncrono de imagens, redimensionamento e exibição otimizada em ImageView. Glide é usado neste projeto para carregar e exibir imagens relacionadas a filmes, programas de TV e artistas.

### ViewModel e LiveData
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) e [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) são componentes da arquitetura Android Jetpack. ViewModel é responsável por fornecer dados à interface do usuário e sobreviver a mudanças de configuração, enquanto LiveData é uma classe observável que permite a comunicação entre ViewModel e as partes da interface do usuário que dependem desses dados. Esses componentes são usados neste projeto para implementar a separação de preocupações e a atualização reativa da interface do usuário.

### Coroutines
[Coroutines](https://developer.android.com/kotlin/coroutines) é um framework assíncrono usado no Kotlin para lidar com programação concorrente e assíncrona de forma simplificada. Ele permite escrever código assíncrono de maneira sequencial, facilitando o tratamento de tarefas demoradas em segundo plano sem bloquear a thread principal. Coroutines são usadas neste projeto para executar operações assíncronas, como chamadas de rede e processamento de dados, de forma eficiente e concorrente.

## Instalação

1. Clone este repositório em sua máquina local.
2. Importe o projeto em sua IDE preferida (Android Studio, por exemplo).
3. Certifique-se de que as dependências do projeto estejam corretamente configuradas.
4. Compile e execute o aplicativo em um dispositivo ou emulador Android compatível.

## Contribuição

Contribuições para este projeto são bem-vindas. Sinta-se à vontade para abrir problemas (issues) e enviar solicitações de pull (pull requests) para melhorar o aplicativo.

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT). Sinta-se livre para utilizar e modificar o código de acordo com as diretrizes da licença.