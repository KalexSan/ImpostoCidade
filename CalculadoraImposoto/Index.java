import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Index {

    public static void main(String[] args) {
        
        ArrayList<Prodution> listaProducao = ReadFiles.ReadProdutionFile();
        TaxCalculator taxCalculator = new TaxCalculator();

        BigDecimal TotalTax = BigDecimal.ZERO;
        BigDecimal TotalValue = BigDecimal.ZERO;
        for (Prodution prodution : listaProducao) {
            BigDecimal tax = taxCalculator.calculateTax(prodution);
            TotalTax = TotalTax.add(tax);
            TotalValue = TotalValue.add(prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade())));
        }

        String valorImpostoFormato = NumberFormat.getCurrencyInstance().format(TotalTax);
        String valorTotalFormato = NumberFormat.getCurrencyInstance().format(TotalValue);
        System.out.println(String.format("Valor total dos impostos: %s", valorImpostoFormato));
        System.out.println(String.format("Valor total dos produção: %s", valorTotalFormato));

    }

}
