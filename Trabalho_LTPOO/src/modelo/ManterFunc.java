/* O projeto só funciona se inicializado pela Home*/
package modelo;

import controle.ControleFunc;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ManterFunc extends DAO {

    public void inserirF(ControleFunc cf) throws Exception {
        try {
            abrirBanco();
            String query = "INSERT INTO Funcionario(nome, idade, cargo, CPF,email,formacao,remuneracao,departamento_id) VALUES (?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, cf.getNome());
            pst.setString(2, String.valueOf(cf.getIdade()));
            pst.setString(3, cf.getCargo());
            pst.setString(4, cf.getCPF());
            pst.setString(5, cf.getEmail());
            pst.setString(6, cf.getFormacao());
            pst.setString(7, String.valueOf(cf.getRemuneracao()));
            pst.setString(8, String.valueOf(cf.getDepartamento_id()));

            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do Funcionário Realizado Com Sucesso!");

            fecharBanco();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Realizar O Cadastro do Funcionário: " + e.getMessage());
        }
    }

    public ArrayList<ControleFunc> PesquisarTudoF() throws Exception {
        ArrayList<ControleFunc> func = new ArrayList<ControleFunc>();
        try {
            abrirBanco();
            String query = "SELECT Funcionario.nome, Funcionario.idade, Funcionario.cargo, Funcionario.CPF, Funcionario.email, Funcionario.formacao, Funcionario.remuneracao, Funcionario.departamento_id, Departamento.nome AS nome_departamento "
                    + "FROM Funcionario INNER JOIN Departamento ON Funcionario.departamento_id = Departamento.id ORDER BY Departamento.nome ASC, Funcionario.nome ASC;";
            pst = (PreparedStatement) con.prepareStatement(query);
            ResultSet tr = pst.executeQuery();
            ControleFunc cf;
            while (tr.next()) {
                cf = new ControleFunc();
                cf.setNome(tr.getString("nome"));
                cf.setIdade(tr.getInt("idade"));
                cf.setCargo(tr.getString("cargo"));
                cf.setCPF(tr.getString("CPF"));
                cf.setEmail(tr.getString("email"));
                cf.setFormacao(tr.getString("formacao"));
                cf.setRemuneracao(tr.getDouble("remuneracao"));
                cf.setDepartamento_id(tr.getInt("departamento_id"));
                func.add(cf);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return func;
    }

    public void deletarFunc(ControleFunc cf) throws Exception {
        try {
            abrirBanco();
            String query = "delete from Funcionario where CPF = ?;";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, cf.getCPF());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Funcionário Deletado com Sucesso!");
            fecharBanco();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar o Funcionário: " + e.getMessage());
        }
    }

    public boolean atualizarFunc(ControleFunc cf) throws Exception {
        try {
            abrirBanco();
            String query = "UPDATE Funcionario SET idade = ?, cargo = ?, email = ?, formacao = ?, remuneracao = ?, departamento_id = ? WHERE CPF = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, cf.getIdade());
            pst.setString(2, cf.getCargo());
            pst.setString(3, cf.getEmail());
            pst.setString(4, cf.getFormacao());
            pst.setDouble(5, cf.getRemuneracao());
            pst.setInt(6, cf.getDepartamento_id());
            pst.setString(7, cf.getCPF());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionário Atualizado com Sucesso!");
            fecharBanco();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar o Funcionário: " + e.getMessage());
            return false;
        }
    }

}
