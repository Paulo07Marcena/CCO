import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Conexao {

    private JdbcTemplate conexao;

    public Conexao() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:./teste_banco");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        conexao = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoDoBanco() {
        return conexao;
    }
}
