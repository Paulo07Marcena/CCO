package dao.maquina;

import database.Conexao;
import model.maquina.Processo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProcessoDAO {
    private Conexao conexao = new Conexao();
    private JdbcTemplate db = conexao.getConexaoDoBanco();
    
    public void insertProcessos(List<Processo> processos, Integer fkServidor) {

        for (Processo processo : processos) {
            db.update(
                    "INSERT INTO Processos (id_processos, fk_servidor, pid_processos, nome_processos, uso_memoria_processos, uso_cpu_processos)" +
                            " VALUES (?, ?, ?, ?, ?, ?)",
                    processo.getId(),
                    fkServidor,
                    processo.getPid(),
                    processo.getNome(),
                    processo.getUsoMemoria(),
                    processo.getUsoCpu());
        }
    }
}
