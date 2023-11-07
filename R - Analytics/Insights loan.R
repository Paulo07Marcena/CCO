library(readxl)
dados <- read_excel("C:/Users/mathe/OneDrive/Ambiente de Trabalho/Reis/Faculdade/Calculo computacional/08.11.2023/Base de dados loan .xlsx", 
     col_types = c("text", "text", "text", 
         "numeric", "text", "text", "numeric", 
         "numeric", "numeric", "numeric", 
         "numeric", "text", "text"))



dados_casados <- dados[dados$Casado == "Yes" & !is.na(dados$Emprestimo), ]
dados_solteiros <- dados[dados$Casado == "No" & !is.na(dados$Emprestimo), ]


grafico_casados <- ggplot(dados_casados, aes(x = Casado, fill = Emprestimo)) +
  geom_bar(position = "dodge") +
  labs(title = "Relação entre Pessoas Casadas e Empréstimos Aprovados",
       x = "Casado",
       y = "Empréstimos Aprovados") +
  scale_fill_manual(values = c("Y" = "green", "N" = "red")) 

grafico_solteiros <- ggplot(dados_solteiros, aes(x = Casado, fill = Emprestimo)) +
  geom_bar(position = "dodge") +
  labs(title = "Relação entre Pessoas Casadas e Empréstimos Aprovados",
       x = "Solteiro",
       y = "Empréstimos Aprovados") +
  scale_fill_manual(values = c("Y" = "green", "N" = "red")) 

print(grafico_solteiros)

casados_aprovados <- table(dados_casados$Emprestimo)
solteiros_aprovados <- table(dados_solteiros$Emprestimo)

mediaRendaCasados <- mean(dados_casados$Renda)
mediaRendaSolteiros <- mean(dados_solteiros$Renda)

mediaDeRenda <- data.frame(
  Categoria = c("Casados", "Solteiros"),
  MediaRenda = c(5656.561, 5022.985)
)

grafico <- ggplot(mediaDeRenda, aes(x = Categoria, y = MediaRenda, fill = Categoria)) +
  geom_bar(stat = "identity") +
  labs(title = "Média de Renda para Casados e Solteiros",
       x = "Estado Civil",
       y = "Média de Renda") +
  theme_minimal()





