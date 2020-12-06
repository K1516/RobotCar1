# Mobiiliohjattava robottiauto

#### Tekijänä Risto Laine

Projektina tässä repositoriossa on mobiiliohjattava robottiauto. Tavoitteena on saada raspberry pi:llä toimiva robottiauto, joka yhdistetään samassa wifi-verkossa olevaan android-puhelimeen, jotta sitä voidaan ohjata sovelluksen kautta. Auton liikkuminen on siis tehty raspberry pi:llä ja puhelminen yhdistämiseen käytetään paho mqtt:n kanssa tehtyä langatonta yhdistämistä puhelimeen. Projekti on aika yksinkertainen ja siitä löytyy paljon kehitysmahdollisuutta, jos niin haluaa (esim. lisäämällä kameran, jotta ei tarvitse nähdä autoa itsessään vaan pystyt ohjaamaan sitä kameran kanssa, jos vain langaton verkko riittää pitkälle. 

Työssä käytettynä on opiskelijabudjettiin sopinut robottiauton aloituspakkaus, joka sisältää kaksi moottria, joihin kuuluvat renkaat, paristokotelo virralle, etupyöräksi moottoroimaton kääntyvä pyörä, sekä lisäksi muovinen toinen kerros kiinnikkeineen, joita en itse ainakaan käyttänyt. Eli lähinnä halvin vaihtoehto mikä projektin aloittaessa oli budjetille sopiva. Auton liikkuvuus on tehty Raspberry Pi 3:sella, virransäätöön laitettuna vielä raspberryn ja moottoreiden väliin motor stepper. Akkuna käytin paristojen sijaan virtapankkia, sekä viimeisenä tietenkin android pohjainen puhelin, jotta saat tehtyä samanlaisen sovelluksen auton ohjaamiseen, toki jos haluaa voi myös käyttää langatonta näppäimistöä, koska koodihan toimii myös sillä pienellä muutoksella.

Työn ohjelmointiin tarvitaan android studio sovelluksen luontiin sekä raspberryllä käytetään pythonia, siihen tarvittavat asennukset raspberryyn pitää tehdä tietenkin. 


Lisätietoja löytyy [wikisivulta](https://github.com/K1516/RobotCar1/wiki)
