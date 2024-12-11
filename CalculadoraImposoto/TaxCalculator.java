import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.EnumMap;

public class TaxCalculator {

    private static final EnumMap<FederalUnit, BigDecimal> TAXES = new EnumMap<>(FederalUnit.class);
    
    static {
        TAXES.put(FederalUnit.AMAZONAS, new BigDecimal("9.99"));
        TAXES.put(FederalUnit.ALAGOAS, new BigDecimal("10.10"));
        TAXES.put(FederalUnit.ACRE, new BigDecimal("11.11"));
        TAXES.put(FederalUnit.AMAPA, new BigDecimal("12.12"));
        TAXES.put(FederalUnit.BAHIA, new BigDecimal("13.13"));
        TAXES.put(FederalUnit.PARA, new BigDecimal("14.14"));
        TAXES.put(FederalUnit.MATO_GROSSO, new BigDecimal("15.15"));
        TAXES.put(FederalUnit.MINAS_GERAIS, new BigDecimal("16.16"));
        TAXES.put(FederalUnit.MATO_GROSSO_DO_SUL, new BigDecimal("17.17"));
        TAXES.put(FederalUnit.GOIAS, new BigDecimal("18.18"));
        TAXES.put(FederalUnit.MARANHAO, new BigDecimal("19.19"));
        TAXES.put(FederalUnit.RIO_GRANDE_DO_SUL, new BigDecimal("20.20"));
        TAXES.put(FederalUnit.TOCANTINS, new BigDecimal("21.21"));
        TAXES.put(FederalUnit.PIAUI, new BigDecimal("22.22"));
        TAXES.put(FederalUnit.SAO_PAULO, new BigDecimal("23.23"));
        TAXES.put(FederalUnit.RONDONIA, new BigDecimal("24.24"));
        TAXES.put(FederalUnit.RORAIMA, new BigDecimal("25.25"));
        TAXES.put(FederalUnit.PARANA, new BigDecimal("26.26"));
        TAXES.put(FederalUnit.CEARA, new BigDecimal("27.27"));
        TAXES.put(FederalUnit.PERNAMBUCO, new BigDecimal("28.28"));
        TAXES.put(FederalUnit.SANTA_CATARINA, new BigDecimal("29.29"));
        TAXES.put(FederalUnit.PARAIBA, new BigDecimal("30.30"));
        TAXES.put(FederalUnit.RIO_GRANDE_DO_NORTE, new BigDecimal("31.31"));
        TAXES.put(FederalUnit.ESPIRITO_SANTO, new BigDecimal("32.32"));
        TAXES.put(FederalUnit.RIO_DE_JANEIRO, new BigDecimal("33.33"));
        TAXES.put(FederalUnit.SERGIPE, new BigDecimal("34.34"));
        TAXES.put(FederalUnit.DISTRITO_FEDERAL, new BigDecimal("35.35"));
    }

    public BigDecimal calculateTax(Prodution prodution) {
        BigDecimal TaxValue = BigDecimal.ZERO;
        FederalUnit localProducao = prodution.getLocalProducao();

        BigDecimal tax = TAXES.get(localProducao);
        if (tax != null) {
            TaxValue = prodution.getValorUnitario()
            .multiply(new BigDecimal(prodution.getQuantidade()))
            .divide(tax, MathContext.DECIMAL128);
        } else {
            throw new IllegalArgumentException("Unidade Federativa inválida: " + localProducao);
        }
        
        return TaxValue.setScale(2, RoundingMode.UP);
    }

}
