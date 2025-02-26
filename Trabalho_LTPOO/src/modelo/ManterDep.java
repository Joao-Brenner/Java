/* O projeto só funciona se inicializado pela Home*/
package modelo;

import controle.ControleDep;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManterDep extends DAO {

    public void inserirD(ControleDep cd) throws Exception {
        try {
            abrirBanco();
            String query = "INSERT INTO Departamento(nome, andar) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, cd.getNome());
            pst.setString(2, String.valueOf(cd.getAndar()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do Departamento Realizado Com Sucesso!");
            fecharBanco();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Realizar O Cadastro do Departamento: " + e.getMessage());
        }
    }

    public ArrayList<ControleDep> PesquisarTudoD() throws Exception {
        ArrayList<ControleDep> dep = new ArrayList<ControleDep>();
        try {
            abrirBanco();
            String query = "select id, nome,andar FROM Departamento";
            pst = (PreparedStatement) con.prepareStatement(query);
            ResultSet tr = pst.executeQuery();
            ControleDep cd;
            while (tr.next()) {
                cd = new ControleDep();
                cd.setId(tr.getInt("id"));
                cd.setNome(tr.getString("nome"));
                cd.setAndar(tr.getInt("andar"));
                dep.add(cd);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return dep;
    }

    public void deletarDep(ControleDep cd) throws Exception {
        try {
            abrirBanco();
            String queryF = "DELETE FROM Funcionario WHERE departamento_id = ?";
            pst = (PreparedStatement) con.prepareStatement(queryF);
            pst.setInt(1, cd.getId());
            pst.execute();
            String queryD = "delete from Departamento where id = ?;";
            pst = (PreparedStatement) con.prepareStatement(queryD);
            pst.setInt(1, cd.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Departamento Deletado com Sucesso!");
            fecharBanco();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar o Departamento: " + e.getMessage());
        }
    }

    public boolean atualizarDep(ControleDep cd) throws Exception {
        try {
            abrirBanco();
            String query = "UPDATE Departamento SET nome = ?, andar = ? WHERE id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, cd.getNome());
            pst.setInt(2, cd.getAndar());
            pst.setInt(3, cd.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Departamento Atualizado com Sucesso!");
            fecharBanco();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar o Departamento: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<ControleDep> PesquisarDepNome(String nome) throws Exception {
        ArrayList<ControleDep> dep = new ArrayList<ControleDep>();
        try {
            abrirBanco();
            String query = "SELECT * FROM Departamento WHERE nome = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, nome);
            ResultSet tr = pst.executeQuery();
            ControleDep cd;
            while (tr.next()) {
                cd = new ControleDep();
                cd.setId(tr.getInt("id"));
                cd.setNome(tr.getString("nome"));
                cd.setAndar(tr.getInt("andar"));
                dep.add(cd);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return dep;
    }
}
