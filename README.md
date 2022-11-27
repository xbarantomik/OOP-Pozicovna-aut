# Požičovňa áut PABT

Jedná sa aplikáciu požičovne áut s názvom PABT. Aplikácia, ktorá by sa dala využiť pri prevádzke auto požičovne. Používateľ si môže prenajať auto, pozrieť si svoju objednávku, prípadne auto vrátiť skôr. Keď sa prihlási zamestnanec, tak má k dispozícii zoznamy všetkých áut, požičaných a dostupných áut, zákazníkov a objednávok. Admin účet zamestnanca môže pridávať nových zamestnancov.


##   Priebeh programu:
#### Ako zákazník
Ako ID / login zadám číslo OP, vložím ďalšie údaje vrátane sumy, ktorú mám k dispozícii. Vyberiem si z ponuky áut a na ako dlho si chcem dané auto požičať. Ukáže sa mi zhrnutie objednávky a potvrdím objednanie. Počas platnej objednávky si môžem skontrolovať svoju objednávku, prípadne ju skoršie vrátiť. Pokiaľ auto (objednávku) vrátim po uplynutí doby prenájmu, nevráti sa mi záloha a moje číslo OP je bude tzv. BanListe.

#### Ako zamestnanec
Použijem svoj login a heslo na prihlásenie sa do systému. Môžem si prezrieť všetky dostupné zoznamy. Ak sa prihlásim ako admin, môžem vytvoriť login a heslo pre nových zamestnancov.

## Zatial zaregistrovaní zamestnanci

    login: login   heslo: a
    login: swf     heslo: leia
    login: swm     heslo: luke
    login: joujou  heslo: bardejou
    ADMIN:
    login: admin   heslo: admin


## Zatial zaregistrovaní zákazníci

    ID: AA123456
    ID: BB123456
    ID: CC123456
    ID: late1
    ID: late2


Posledné dva sú na otestovanie prípadu, keď zákazník ide vrátiť auto po stanovenom dátume.

ID "skuska" je na Banliste.

S pozdravom,

Adam Baran-Tomik
