@ui @e2e
Feature: Medunna Odasi Olusturma

Background: Kullanici Girisi Yapma
Given Medunna web sitesine gidilir
When User simgesine tiklanir
And Sign in secenegine tiklanir
And Username kutusuna kullanici adi girilir
And Password kutusuna password girilir
And Sign in butonuna tiklanir

Scenario Outline: Create Room
When Items&Titles secenegine tiklanir
And Room secenegine tiklanir
And Create a new Room butonuna tiklanir
And Room Number kutusuna bir oda_no girilir
And Room Type menusunden SUITE secenegi secilir
And Status kontrol kutusuna tiklanir
And Price kutusuna "<fiyat>" degeri girilir
And Description kutusuna bir "<aciklama>" girilir
And Save butonuna tiklanir
And Uygulama kapatilir
Examples:
| fiyat | aciklama                            |
| 123   | End To End Test icin olusturulmustur|