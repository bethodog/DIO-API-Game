# DIO-API-Game
Projeto Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway

## Diagrama de classes
```mermaid
classDiagram
    class Game {
        +int id
        +String title
        +int game_year
        +float score
        +String imgUrl
        +String shortDescription
        +String longDescription
    }
    class Genre {
        +int id
        +String name
        +int age
    }
    class Platform {
        +int id
        +String name
    }
    class Language {
        +int id
        +String name
    }

    Game "1" -- "1" Genre : has
    Game "1" -- "N" Platform : is available on
    Game "1" *-- "N" Language : has
```

## Acessos

URL Padrão
- http://localhost:8080/games	
	
Doc API	
- http://localhost:8080/swagger-ui/index.html

H2 Database
- http://localhost:8080/h2-console/	