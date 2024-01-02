@api @e2e
Feature: Get Room Request
  Scenario: Get Room Request ile Dogrulama
    Given Oda ID bilgisi alinir
    When Get request gonderilir
    Then Veriler dogrulanir