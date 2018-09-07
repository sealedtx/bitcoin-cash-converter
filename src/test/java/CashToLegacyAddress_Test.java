/*-
 * -----------------------LICENSE_START-----------------------
 * Bitcoincash address converter
 * %%
 * Copyright (C) 2018 Igor Kiulian
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -----------------------LICENSE_END-----------------------
 */



import com.github.kiulian.converter.AddressConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Convert address from bitcoincash to legacy format")
public class CashToLegacyAddress_Test {

    @Test
    @DisplayName("Version - P2PKH")
    void testCashToLegacyP2PKH() {
        String legacy_address = "18uzj5qpkmg88uF3R4jKTQRVV3NiQ5SBPf";
        String cash_address = "bitcoincash:qptvav58e40tcrcwuvufr94u7enkjk6s2qlxy5uf9j";

        assertEquals(legacy_address, AddressConverter.toLegacyAddress(cash_address));
    }

    @Test
    @DisplayName("Version - P2SH")
    void testCashToLegacyP2SH() {
        String legacy_address = "3CWFddi6m4ndiGyKqzYvsFYagqDLPVMTzC";
        String cash_address = "bitcoincash:ppm2qsznhks23z7629mms6s4cwef74vcwvn0h829pq";

        assertEquals(legacy_address, AddressConverter.toLegacyAddress(cash_address));
    }
}
