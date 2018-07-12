import converter.AddressConverter;

public class Main {


    public static void main(String[] args) {

        String legacy_address = "18uzj5qpkmg88uF3R4jKTQRVV3NiQ5SBPf";
        String cash_address = "bitcoincash:qptvav58e40tcrcwuvufr94u7enkjk6s2qlxy5uf9j";

        System.out.println("legacy -> cash: " + cash_address.equals(AddressConverter.toCashAddress(legacy_address)));

        //test cash -> legacy
        System.out.println("cash -> legacy: " + legacy_address.equals(AddressConverter.toLegacyAddress(cash_address)));
    }
}
