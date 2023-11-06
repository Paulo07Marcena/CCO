# Crawler desenvolvido pelo aluno Paulo Reis

import csv
import zipfile
import requests
import mysql.connector as sql
import mysql.connector.errorcode


# Conexão com o banco de dados
def executar(instrucao, valores):
    try:
        conexao = sql.connect(
            host="localHost",
            password="sua senha",
            user="root",
            database="AmericanVehicle",
        )
        comando = conexao.cursor()

    except mysql.connector.Error as error:
        print(f"Erro ao efetuar conexão >>> {error}")

    try:
        print(
            f"""
            Comando >>> {instrucao}
            Valores >>> {valores}
        """
        )

        if valores:
            comando.execute(instrucao, valores)

        conexao.commit()

        comando.close()
        conexao.close()

    except mysql.connector.Error as erro:
        print("Erro ao executar comando!")
        print(erro)


baseDeDados = "https://storage.googleapis.com/kaggle-data-sets/3743680/6479897/bundle/archive.zip?X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=gcp-kaggle-com%40kaggle-161607.iam.gserviceaccount.com%2F20231106%2Fauto%2Fstorage%2Fgoog4_request&X-Goog-Date=20231106T134726Z&X-Goog-Expires=259200&X-Goog-SignedHeaders=host&X-Goog-Signature=2fe192479d27979e413025335fa80b7fdd20bdf2d9b3e9d3ca5ec0ca4761fea546cb8d7d23abee23a24c2fb6fd921f2b180b11f560a491318d305bb9670c50f00b56220cc0904a3b1df9807639e385ac00a7cc566d6fad56fdf6a13490e9c2b5a36bc6039d09880cf5cefdbc6dbc5a7405c51a0249aad737d5cca227cdacc782df703ca8dc193be101d780dc3996e6f06209cc5285966625df554cee42cd3d0cd1662d6907e0571f3da04f184faa43e2bfea5f262ab08decbd2bdbb3cbd99e781a199a3ac22c5f2be4377c447f093903d70cfd30d98c3b31ae449900be3ba3c3ad37f384e0ac6fc9cde74bc99d0fb4f0cfbae7409f0b4666979c1777a44bb382"


with requests.Session() as s:
    download = s.get(baseDeDados)
    with open("baseDeDados.zip", "wb") as f:
        f.write(download.content)

with zipfile.ZipFile("baseDeDados.zip", "r") as zip_file:
    zip_file.extractall("BaseDeDados")


with open("BaseDeDados\prices_clean.CSV") as arq_csv:
    arq_csv = csv.reader(arq_csv, delimiter=",")

    for i, linha in enumerate(arq_csv):
        if i > 1:
            valores = [
                linha[0],
                linha[1],
                linha[2],
                linha[3],
            ]
            executar("insert into carros value (null, %s, %s, %s, %s);", valores)
