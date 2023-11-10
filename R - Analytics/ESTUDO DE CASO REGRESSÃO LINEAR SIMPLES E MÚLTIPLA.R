install.packages("ggplot2")
install.packages("dplyr")
install.packages("broom")
install.packages("ggpubr")

library("ggplot2")
library("dplyr")
library("broom")
library("ggpubr")

income.data <- read.csv("C:/Users/mathe/OneDrive/Ambiente de Trabalho/Reis/Faculdade/Calculo computacional/10.11.2023/income.data.csv")
View(income.data)

income.data$X <- NULL
summary(income.data)

hist(income.data$happiness)

plot(income.data$income, income.data$happiness)

income.happiness.lm <- lm(income.data$happiness ~ income.data$income, data = income.data)

summary(income.happiness.lm)


par(mfrow=c(2,2), mar=c(4, 4, 2, 1))
plot(income.happiness.lm)

par(mfrow=c(1,1))

income.graph <- ggplot(income.data, aes(x=income, y=happiness)) +
  geom_point()

income.graph

income.graph <- income.graph + geom_smooth(method = "lm", col="black")

install.packages("ggpubr")
install.packages("ggplot2")
install.packages("tidyverse")
install.packages("ggmisc")

library(ggpubr)
library(ggplot2)
library(tidyverse)
library(ggmisc)

income.graph <- income.graph + stat_regline_equation(label.x = 3, label.y = 7)

income.graph

income.graph + theme_bw() + labs(title = "Reported happines as a function of income",
                                 x = "Income (x$10,000)", 
                                 y = "Happiness score (0 to 10)")
