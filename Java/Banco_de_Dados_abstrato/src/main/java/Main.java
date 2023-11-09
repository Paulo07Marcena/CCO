import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        JdbcTemplate con = new Conexao().getConexaoDoBanco();

        con.execute("DROP TABLE IF EXISTS produto");
        con.execute("""
                CREATE TABLE produto (
                id INT PRIMARY KEY AUTO_INCREMENT,
                nome VARCHAR(50) NOT NULL,
                preco_base DECIMAL(10,2) not null,
                tipo VARCHAR(50) NOT NULL,
                tensao INT,
                peso DECIMAL(10, 2),
                fabricante VARCHAR(50),
                tamanho CHAR(5),
                cor VARCHAR(50),
                white_label  BOOLEAN
                );
                """
        );



        Eletronico e1 = new Eletronico(null, "Gameboy", 500.00, 127, 500.00, "Nitendo");

        con.update("INSERT INTO produto (nome, preco_base,tipo, tensao, peso, fabricante) VALUES (?,?,'Eletronico',?,?,?)",
                e1.getNome(),
                e1.getPrecoBase(),
                e1.getTensao(),
                e1.getPeso(),
                e1.getFabricante()
                );

        List<Produto> todosOsProdutos =
        con.query("""
                Select * from produto
                """, new ProdutoRowMapper()
        );
        System.out.println(todosOsProdutos);

    }
}
