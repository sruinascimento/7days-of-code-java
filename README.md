

# R Movie

Projeto de backend com a linguagem Java, é um desafios dos ![Seven Days of Code](https://7daysofcode.io/matricula/java) que visa gerar um site HTML com os dados que foram consumidos da API do ![IMDB](https://imdb-api.com/) e da ![Marvel](https://developer.marvel.com/).

| 🪧 Vitrine.Dev |     |
| -------------  | --- |
| ✨ Nome        | R Movie
| 🏷️ Tecnologias | Java, HTML5, CSS3, BootStrap
| 🚀 URL         | https://sruinascimento.github.io/7days-of-code-java/
| 🤿 Desafio | https://www.alura.com.br/imersao-java

![](https://user-images.githubusercontent.com/57668890/180806003-6765c6ae-b347-4e0c-82a5-bc224e08d9a8.png#vitrinedev)


## 🔨 Tecnologias

- ``Java - 17.0.2 2022-01-18 LTS``
- ``HTML5``
- ``CSS3``
- ``Bootstrap``
- ``Git``


 ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
 ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
 ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
 ![Bootstrap](https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
 ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

## 🤿 7 dias de código 
<img src="https://camo.githubusercontent.com/459f141bd5e24c179a0e2dd49691e290ed5c5d4b4cb97767daee7cfaf6e31121/687474703a2f2f696d672e736869656c64732e696f2f7374617469632f76313f6c6162656c3d535441545553266d6573736167653d434f4e434c5549444f26636f6c6f723d475245454e267374796c653d666f722d7468652d6261646765">


## 1º Dia
  - [x] criar o código Java que executará uma requisição HTTP do tipo GET. Você pode usar o pacote java.net.http e as classes HttpRequest, HttpClient e HttpResponse, além da classe URI.
  - [x] executar a requisição e pegar a resposta (o JSON).
  - [x] imprimir o corpo da resposta no console.
  
  
## 2º Dia
  - [x] parsear as respostas, extrair o json.
  - [x] fazer uso de Expressões regulares para o parser.
  - [x] utilizar List<String> para cada atributo.
  

## 3º Dia
  - [x] utilizar conceitor de OO.
  - [x] modelar uma classe para filmes com os atributos title, url, rate e year. 
  
  
## 4º Dia
  - [x] criar uma nova classe HTMLGenerator, que recebe no construtor um Writer (por exemplo, PrintWriter).
  - [x] adicionar um método chamado ‘generate’, que irá receber uma List<Movie>.
  - [x] aplicar estilização CSS, ou utilizar modelos do Bootstrap por exemplo.
  
  
 ## 5º Dia
   - [x] criar uma classe chamada ImdbApiClient para encapsular a requisição para a API do IMDB .
   - [x] criar uma classe para o parseamento JSON, pois o mesmo está avulso na classe Main.


## 6º Dia
   - [x] Criar uma interface chamada Content definir o comportamento comum de qualquer conteúdo. A interface terá quatro métodos com retornos do tipo string, os quais são: title(), urlImage(), rating() e year().
   - [x] classe movie deverá implementar a interface Content.
   - [x] criar um interface JsonParser, com o método parse(). 
   - [x] consumir API da Marvel.
   - [x] crie uma interface chamada 'APIClient' com um método getBody().
   - [x] consumir a API da Marvel criando um cliente da API e JsonParser. Aqui também, você precisará de uma conta para gerar a API Key (chave pública e privada).
   - [x] adicionar um novo método na interface chamado type(). Esse método irá devolver o tipo do conteúdo em questão, por exemplo: Movie, Series, ComicBook, etc.


## 7º Dia
   - [x] implementar a interface Comparable<? extends Content> na classe (ou record) Movie (e também na classe Series, se você a tiver criado). Para começar, você pode implementar o método usando a nota (rating) como parâmetro de comparação.
  - [x] o método sort() está sobrecarregado, então você pode passar um Comparator como segundo parâmetro para inverter a lista
  - [x] implementar outras formas de comparação usando um Comparator.
  
  
