dados <- data.frame(
  tempo = c(96,92,106,100,98,104,110,101,116,106,109,100,112,105,118,108,113,112,
            127,117),
  idade = c(20,20,20,20,25,25,25,25,30,30,30,30,35,35,35,35,40,40,40,40)
)

dados

install.packages("devtools")
devtools::install_github("tidyverse/ggplot2")

library(ggplot2)
ggplot(dados, aes(x = idade, y = tempo)) + geom_point()

modelo <- lm(data = dados,formula = tempo ~ idade)

modelo$coefficients

summary(modelo)

ggplot(dados, aes(x = idade, y=tempo)) +
       geom_point() +
       geom_smooth(method =lm, se = FALSE)

predict(modelo)

valor_aj <- predict(modelo)

dados$id <- c(1:20)

library(dplyr)


