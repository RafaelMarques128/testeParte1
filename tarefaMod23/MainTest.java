package br.com.rpires.tarefaMod23;

import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class MainTest {

    @Test
    public void testListaMulheresContemSomenteFeminino() {
        // Dados de entrada simulados
        String input = "MARCIO-MASCULINO,LUARA-FEMININO,LETICIA-FEMININO,JOAO-MASCULINO";

        // Reutilizando o método processaEntrada
        List<String> lista = Main.processaEntrada(input);

        // Executando o filtro de mulheres
        List<String> listaMulheres = Main.filtrarMulheres(lista);

        // Verificando se todas as entradas da listaMulheres contêm "FEMININO"
        for (String mulher : listaMulheres) {
            String[] dados = mulher.split("-");
            String genero = dados[1];
            Assert.assertEquals("FEMININO", genero);
        }

        // Verificando se a listaMulheres contém exatamente as mulheres esperadas
        Assert.assertEquals(2, listaMulheres.size());
        Assert.assertTrue(listaMulheres.contains("LUARA-FEMININO"));
        Assert.assertTrue(listaMulheres.contains("LETICIA-FEMININO"));
    }
}
