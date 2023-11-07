baseDeDados <- read.csv("C:/Users/mathe/OneDrive/Ambiente de Trabalho/Reis/Faculdade/Calculo computacional/06.11.2023/Crawler/BaseDeDados/baseDeDados.csv", sep=";")

carros_por_marca <- table(baseDeDados$marca)

carroPorMarca <- data.frame(Marca = names(carros_por_marca), Quantidade = carros_por_marca)

ggplot(carroPorMarca, aes(x = carroPorMarca$Marca, y = carroPorMarca$Quantidade.Freq)) +
       geom_bar(stat = "identity", fill = "blue") +
       theme(axis.text.x = element_text(angle = 90, hjust = 1)) +
       labs(title = "Quantidade de Carros por Marca", x = "Marca", y = "Quantidade")


media_por_marca <- tapply(baseDeDados$preco, baseDeDados$marca, mean)

mediaDePrecoPorMarca <- data.frame(Marca = names(media_por_marca), Quantidade = media_por_marca)

mediaDePrecoPorMarcaV2 <- subset(mediaDePrecoPorMarca, Marca != "Bugatti")

mediaDePrecoPorMarca <- mediaDePrecoPorMarcaV2

media <- round(mediaDePrecoPorMarca$Quantidade / 1000, 2)

mediaDePrecoPorMarca$Quantidade <- media

ggplot(mediaDePrecoPorMarca, aes(x = mediaDePrecoPorMarca$Marca, y = mediaDePrecoPorMarca$Quantidade)) +
       geom_bar(stat = "identity", fill = "blue") +
       theme(axis.text.x = element_text(angle = 90, hjust = 1)) +
       labs( title = "Média de preço por Marca", x = "Marca", y = "Preço Médio X1000")