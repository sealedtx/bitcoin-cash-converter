bitcoin-cash-converter
============

[![Build Status](https://travis-ci.org/sealedtx/NNCourseproject.svg?branch=master)](https://travis-ci.org/sealedtx/NNCourseproject)

Simple address converter from legacy to [new bitcoincash format](https://github.com/bitcoincashorg/bitcoincash.org/blob/master/spec/cashaddr.md) and vice versa. It is fully covered by unit tests.

Usage
-----

The class `AddressConverter` is the entrypoint to the bitcoin-cash-converter API, use it to convert addresses.

### Legacy -> Bitcoincash

You can convert legacy address from a `String` to new bitcoincash format:

```java
String bitcoincash_address = AddressConverter.toCashAddress(legacy_address);
```

### Bitcoincash -> Legacy

You can convert bitcoincash address from a `String` with format "bitcoincash:${your_address}" to legacy fomat:

```java
String legacy_address = AddressConverter.toCashAddress(legacy_address);
```

### Example:

```java
String legacy_address = "18uzj5qpkmg88uF3R4jKTQRVV3NiQ5SBPf";
String bitcoincash_address = AddressConverter.toCashAddress(legacy_address);
System.out.println(bitcoincash_address); // output: bitcoincash:qptvav58e40tcrcwuvufr94u7enkjk6s2qlxy5uf9j

String cash_address = "bitcoincash:qptvav58e40tcrcwuvufr94u7enkjk6s2qlxy5uf9j";
String legacy_address = AddressConverter.toLegacyAddress(legacy_address);
System.out.println(bitcoincash_address); // output: 18uzj5qpkmg88uF3R4jKTQRVV3NiQ5SBPf
```

Include
-------

Deploying on maven coming soon...
