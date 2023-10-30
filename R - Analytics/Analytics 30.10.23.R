pop_sol_cred <- 10000

set.seed(999)

n <- 6048

set.seed(999)

bom.n <- rbinom(n,1,.85)

bom.n

table(bom.n)

str(bom.n)

mean(bom.n)

class_pg <- factor(bom.n,
            levels = c(0,1),
            labels = c("mau","bom"),
            ordered = TRUE
            )

summary(class_pg)

table(class_pg)

data.default<-data.frame(class_pg)

data.default

tail(data.default)

head(data.default)

data.default <- data.frame(table(class_pg))

data.default

colnames(data.default)[2]<-"Freq_absoluta"

colnames(data.default)[1] <- "Status"

data.default<-data.frame(id=1:2,data.default)

Freq_relativa<-

round(data.default$Freq_absoluta/sum(data.default$Freq_absoluta)*100,2)

Freq_relativa<-data.frame(id=1:2,Freq_relativa)

table_padrão<-data.frame(merge(data.default,Freq_relativa))

barplot(table_padrão$Freq_relativa,xlab= "Tipo de Tomador
Crédito",ylab="Frequência_Relativa",col=c("seagreen", "yellowgreen"))

class_pg

prop.table(table(class_pg))

barplot(prop.table(table(class_pg)),xlab="Tipo de tomador de
crédito",ylab="Frequência Absoluta",col=c("red","blue"))

set.seed(123)
idade <- round(rnorm(n,35,5),0)

set.seed(123)
idade <- round(rnorm(n,35,5),0)


sexo <- rbinom(n,1,.5)
sexo <- factor(sexo,
                 levels = c(0,1),
                 labels = c("Homem","Mulher"),
                 ordered = TRUE
)


renda <- round(rnorm(n,2000.00, 250),2)

dados <- data.frame(sexo, renda, idade)

library(ggplot2)


histograma_mulheres <- ggplot(subset(dados, sexo == "Mulher"), aes(x = renda)) +
  geom_histogram(fill = "pink", color = "black", bins = 20) +
  labs(title = "Histograma da Renda para Mulheres",
       x = "Renda",
       y = "Frequência") +
  theme_minimal()

print(histograma_mulheres)


histograma_homem <- ggplot(subset(dados, sexo == "Homem"), aes(x = renda)) +
  geom_histogram(fill = "blue", color = "black", bins = 20) +
  labs(title = "Histograma da Renda para Homens",
       x = "Renda",
       y = "Frequência") +
  theme_minimal()

print(histograma_homem)


