install.packages(c("wordcloud", "RcolorBrewer", "wordcloud2", "tm"))
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
library(tm)


maquinaLog <- read_excel("C:/Users/mathe/OneDrive/Ambiente de Trabalho/Reis/Faculdade/Calculo computacional/13.11.2023/maquinaLog.xlsx")

View(maquinaLog)

docs <- Corpus(VectorSource(maquinaLog$Processo))

dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word = names(words), freq=words)

View(df)

wordcloud(words = df$word, freq = df$freq, min.freq = 1,
                  max.words = 100, random.order = FALSE, rot.per = 0.35,
                  colors = brewer.pal(8, "Dark2"), scale =c(2,1))


