# Metode i tehnike testiranja programske podrške-projektni zadatak

Ovaj projektni zadatak rađen je po uzoru na LV2-Automatsko testiranje Web aplikacija (Frontend) - Selenium Web Driver. Za potrebe zadatka testirane su funkcionalnosti Amazon-a: https://www.amazon.com/. Korišten je IntelliJ, Java JDK, WebDriver Manager(Chrome i Edge driveri), te Selenium server. 
U klasi AmazonTest.java nalazi se 5 testnih slučajeva: 
    productSearchTest - testiranje tražilice za pretraživanje proizvoda
    checkCartTest - testiranje dodavanja proizvoda u košaricu
    deleteProductTest - testiranje brisanja proizvoda iz košarice
    checkFiltersTest - testiranje filtera pri pretraživanju proizvoda
    changeSettingsTest - testiranje funkcionalnosti promjene jezika i valute

Prije samih testova definirana je @BeforeMethod koja će nam omogućiti pokretanje testova u Chrome i Edge browseru. U ovom dijelu je također definiran Selenium Grid koji smanjuje vrijeme skupne obrade i omogućava izvođenje s više preglednika (Cross Browser testing). Selenium Grid pokreće se u cmd s naredbama java -jar selenium-server-<version>.jar hub i java -jar selenium-server-<version>.jar node. Prije toga potrebno je preuzeti Selenium Server i staviti ga u mapu gdje se nalaze i preuzeti driveri. Na localhost:4444 moguće je pratiti izvođenje testova nakon pokretanja. 

Nakon testova nalazi se @AfterMethod koja služi za zatvaranje preglednika nakon svakog završenog testa. 

Svaka stranica Web aplikacije predstavljena je zasebnom klasom koje se nalaze u mapi src/main/java. U njoj su definirani atributi i metode koje će se izvršavati na toj stranici. Klase koje smo definirali za potrebe testiranja zadane aplikacije su: AmazonHomePage koja predstavlja početni zaslon aplikacije, AmazonCartPage koja predstavlja proizvod dodan u košaricu, AmazonFiltersPage koja prikazuje određene proizvode koje je moguće filtrirati za što precizniji rezultat, AmazonProductPage koja predstavlja zaslon odabranog proizvoda, AmazonSearchPage koja predstavlja rezultate pretraživanja proizvoda te AmazonSettingsPage koja postavlja postavke jezika i valute. Metode definirane u navedenim klasama pozivaju se u AmazonTest.java klasi. 

Unutar testng.xml definirano je paralelno izvođenje testova, kao i browseri koji će se koristiti u @BeforeMethod. 

Važno je naglasiti da se prilikom pokretanja može dogoditi da neki testovi padnu. Primjerice, checkCartTest omogućava testiranje dodavanja proizvoda u košaricu. Nakon dodavanja proizvoda u košaricu, web aplikacija šalje povratnu informaciju da je proizvod dodan u košaricu te nudi gumb na košaricu, kako bi smo provjerili nalazi li se dodani proizvod unutra. No, Amazon nudi povratnu informaciju i gumb na dva načina te nije moguće procijeniti na koji način će se pružiti povratna informacija. Stoga se unutar klase AmazonProductPage nalazi grananje koje pokriva oba slučaja i daje metodi do znanja što činiti u kojoj situaciji. Ipak, else ponekad ne prepoznaje putanju elementa što uzrokuje pad testa. Isto tako i za testni slučaj deleteProductTest koji je sličan ranije opisanom testu, uz neke dodatne funkcionalnosti.  
