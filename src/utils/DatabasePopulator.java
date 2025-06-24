package utils;

import java.sql.Date;
import java.sql.SQLException;

import controller.AuxiliarController;
import controller.ClinicaController;
import controller.ConsultaController;
import controller.EnderecoController;
import controller.PetController;
import controller.ReciboController;
import controller.TutorController;
import controller.VeterinarioController;

public class DatabasePopulator {

    public static void populate() {
        try {
            EnderecoController.inserir("69000000", "Av. Amazonas", "1000", "Centro", "Manaus", "AM", "Sala 101");
            EnderecoController.inserir("69010000", "Rua das Flores", "200", "Flores", "Manaus", "AM", "Apto 202");
            EnderecoController.inserir("69020000", "Travessa Doçura", "50", "Aleixo", "Manaus", "AM", null);
            EnderecoController.inserir("69030000", "Rua do Sossego", "150", "Ponta Negra", "Manaus", "AM", "Casa");

            ClinicaController.inserir("VetVida", "12345678000190", "9240001234", "contato@vetvida.com", 1);
            ClinicaController.inserir("PetSaúde", "98765432000110", "9240005678", "suporte@petsaude.com", 2);

            AuxiliarController.inserir("Ana Silva", "12345678900", "CRMV123", "ana@vetvida.com", 1, "9299990001", 3);
            AuxiliarController.inserir("Bruno Costa", "98765432100", "CRMV567", "bruno@petsaude.com", 2, "9299990002", 4);

            VeterinarioController.inserir(1, 1, "Carla Mendes", "11122233344", "CRMV111", "carla@vetvida.com", "Dermatologia", "9298880001");
            VeterinarioController.inserir(2, 2, "Daniel Rocha", "55566677788", "CRMV222", "daniel@petsaude.com", "Cardiologia", "9298880002");

            TutorController.inserir("Eduardo Lima", "22233344455", "eduardo@gmail.com", "9297770001", 3);
            TutorController.inserir("Fernanda Alves", "66677788899", "fernanda@gmail.com", "9297770002", 4);

            PetController.inserir(1, "Rex", Date.valueOf("2018-05-20"), "Canina", "Labrador");
            PetController.inserir(2, "Mimi", Date.valueOf("2020-11-15"), "Felina", "Siamês");

            ConsultaController.inserir(1, 1, 1, Date.valueOf("2025-06-01"), "Coceira intensa", "Dermatite alérgica", "Banho medicamentoso");
            ConsultaController.inserir(2, 2, 2, Date.valueOf("2025-06-05"), "Tosse persistente", "Bronquite", "Antibiótico por 7 dias");

            ReciboController.inserir(1, 250.00, Date.valueOf("2025-06-01"), "Cartão de Crédito", "Consulta e medicação");
            ReciboController.inserir(2, 180.00, Date.valueOf("2025-06-05"), "Dinheiro", "Consulta e exame de raio-x");

            System.out.println("População inicial concluída com sucesso.");

        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro geral: " + e.getMessage());
        }
    }
}
