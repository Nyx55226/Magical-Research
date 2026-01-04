package com.mycompany.mavenproject;

import java.util.ArrayList;
import java.util.List;

public class ObjectiveFactory {
    /* Restituisce la lista completa di tutti gli Objective del gioco (1–13) */
    public static ArrayList<Objective> createAllObjectives() {
        ArrayList<Objective> list = new ArrayList<>();

        list.add(new Objective(
            "1",
            "Raccogli più mana",
            new ArrayList<>(List.of("1")),
            ConditionFactory.getCondition("1"),
            "Sei un mago\n\n"
          + "Raccogliere Mana è utile, ma perché farlo se non hai nulla per cui usarlo?\n"
          + "Ti ricordi lentamente come lanciare incantesimi e ti viene in mente un incantesimo base di Evocazione, Crea Sasso.\n"
          + "Pensi di provarlo presto! Hai sbloccato la capacità di lanciare incantesimi!\n"
          + "Puoi lanciarli premendo l'icona della bacchetta in alto a destra o in basso a destra dello schermo."
        ));

        list.add(new Objective(
            "2",
            "Creare più pietra e acqua",
            new ArrayList<>(List.of("2")),
            ConditionFactory.getCondition("2"),
            ""
        ));

        list.add(new Objective(
            "3",
            "Raccogli più Mana",
            new ArrayList<>(List.of("3")),
            ConditionFactory.getCondition("3"),
            "Il frammento di mana\n\n"
          + "Le riserve di mana della scuola si stanno accumulando. Guardandole, ti rendi conto che potrebbero presto raggiungere il massimo.\n"
          + "Se solo avessi un modo per immagazzinare più mana... Poi ti ricordi cosa avevi imparato da apprendista, ovvero che i frammenti di mana possono aumentare la capacità.\n"
          + "Potremmo comprarne un po' se avessimo abbastanza monete... magari con qualche incantesimo di illusione?\n"
          + "Ora puoi costruire frammenti di mana"
        ));

        list.add(new Objective(
            "4",
            "Crea un frammento di mana",
            new ArrayList<>(List.of("4")),
            ConditionFactory.getCondition("4"),
            "Apparve un ricercatore selvaggio\n\n"
          + "Una donna entusiasta osserva il tuo Mana e nota la grande quantità che possiedi. \"Wow, sarebbe un ottimo materiale di partenza\", afferma."
        ));

        list.add(new Objective(
            "5",
            "Assumi il ricercatore!",
            new ArrayList<>(List.of("5")),
            ConditionFactory.getCondition("5"),
            "Apparve un ricercatore selvaggio\n\n"
          + "Stai cercando di studiare magia qui? È entusiasmante!\n"
          + "Sarei disposta a lavorare qui per una piccola cifra... diciamo 200 monete. Naturalmente, saresti la prima a sapere cosa scopro e sapresti dirmi su cosa dovrei concentrarmi, dice con sincerità.\n"
          + "E allora cosa sarà?"
        ));

        list.add(new Objective(
            "6",
            "Raccogli più Pietra!",
            new ArrayList<>(List.of("6")),
            ConditionFactory.getCondition("6"),
            "Idee per l'archiviazione\n\n"
          + "Accumulare pietre è utile. Mentre vedi le tue riserve avvicinarsi al pieno, inizi a pensare se ci sia un modo per migliorare la situazione.\n"
          + "Forse potresti usare la pietra per creare più spazio? Sembra un'idea intelligente e semplice... potresti creare un magazzino di pietre.\n"
          + "Ora puoi costruire magazzini!"
        ));

        list.add(new Objective(
            "7",
            "Costruisci un Magazzino!",
            new ArrayList<>(List.of("7")),
            ConditionFactory.getCondition("7"),
            "I tuoi ricercatori sono ispirati!\n\n"
          + "Sembra che i tuoi ricercatori siano stati colti da un'esplosione di ispirazione!"
        ));

        list.add(new Objective(
            "8",
            "Continua a fare Ricerca!",
            new ArrayList<>(List.of("8")),
            ConditionFactory.getCondition("8"),
            "È ora di guardare fuori\n\n"
          + "I nostri studi sulla magia stanno iniziando a dare i loro frutti! Con i recenti progressi, siamo pronti ad ampliare i nostri orizzonti. Il campus è grande, ma offre solo un limite!\n"
          + "Sembra che ci sia una foresta qui vicino dove potremmo trovare legna, che potrebbe aiutarci a sviluppare ulteriormente la nostra istituzione...\n"
          + "Ora puoi raccogliere legna!"
        ));

        list.add(new Objective(
            "9",
            "Raccogli più Legno!",
            new ArrayList<>(List.of("9")),
            ConditionFactory.getCondition("9"),
            "Lavorazione del legno\n\n"
          + "Queste gite nella foresta stanno iniziando a diventare noiose. Stai iniziando a chiederti se c'è un modo per renderti la vita più facile.\n"
          + "Forse c'è un modo? Forse possiamo riutilizzare il legno che abbiamo ottenuto per costruire qualcosa di più grande? Ti perdi nei tuoi pensieri mentre torni al campus.\n"
          + "Quando arrivi, hai già capito. Depositi di legname proprio ai margini della foresta. Può sicuramente funzionare!\n"
          + "Ora puoi costruire depositi di legname!"
        ));

        list.add(new Objective(
            "10",
            "Costruisci un dormitorio per gli apprendisti!",
            new ArrayList<>(List.of("10")),
            ConditionFactory.getCondition("10"),
            "Il primo apprendista\n\n"
          + "La costruzione del primo dormitorio per apprendisti è terminata! Festeggiate davanti a un piccolo pubblico. Noti che l'apprendista di prima è ancora lì. Ti avvicini a lui, anche se sembra ancora timoroso e fa un profondo inchino.\n"
          + "\"È... un alloggio che mi potrebbe servire?\", dice con voce timida. Annuisci e gli chiedi se gli piacerebbe diventare il tuo primo apprendista. Trema, visibilmente e palesemente nervoso.\n"
          + "\"Sarebbe fantastico... È un onore poter imparare da uno come te, preside. Mi trasferisco subito.\n"
          + "Hai sbloccato gli Apprendisti! Gli Apprendisti possono lanciare automaticamente incantesimi per te dopo un determinato periodo di tempo. Puoi gestirli nella sezione Apprendisti, nel menu a sinistra.\""
        ));

        list.add(new Objective(
            "11",
            "Raccogli 800 monete!",
            new ArrayList<>(List.of("11")),
            ConditionFactory.getCondition("11"),
            "Deposito monete\n\n"
          + "Stai accumulando un sacco di monete! Sarebbe saggio trovare un posto dove metterle.\n"
          + "I magazzini sono stati utili; la pietra si è dimostrata un ottimo materiale per tantissime cose. Pensi di usarla per un edificio specializzato per conservare il denaro.\n"
          + "Ti preoccupano i banditi, ma sei convinto che a lungo andare ne varrà la pena.\n"
          + "Ora puoi costruire i Vault!"
        ));

        list.add(new Objective(
            "12",
            "Continua a fare ricerca!",
            new ArrayList<>(List.of("12")),
            ConditionFactory.getCondition("12"),
            "Stazione di lavorazione\n\n"
          + "La tua attenzione viene interrotta dalla tua ricercatrice, che ti urla contro: \"Preside!\".\n"
          + "Raccogliere risorse come legno e ferro è fantastico, continua. Non sarebbe ancora più interessante se potessimo ricavarne oggetti più complessi?"
        ));

        list.add(new Objective(
            "13",
            "Costruisci una stazione di lavoro!",
            new ArrayList<>(List.of("13")),
            ConditionFactory.getCondition("13"),
            "È stato difficile, ma la postazione di lavoro è finita! Il tuo ricercatore, pieno di gioia, corre verso di essa e la esamina da ogni angolazione. Noti che anche il tuo apprendista se ne accorge e la osserva con curiosità.\n"
          + "Una postazione di lavoro... Ti stai chiedendo se potresti farci subito qualcosa?\n"
          + "\"Evocazione e Incantamento\", dice la tua ricercatrice, passandoti accanto con l'apprendista. \"Concentra la nostra ricerca su quelle scuole e dovremmo essere in grado di creare oggetti.\" Escono insieme.\n"
          + "Hai sbloccato le funzionalità \"Inventario\" e \"Creazione\"! Puoi accedere al tuo inventario tramite il menu a sinistra. Puoi creare oggetti dalla schermata dell'inventario."
        ));
        list.add(new Objective(
            "14",
            "Costruisci un oggetto",
            new ArrayList<>(List.of("14")),
            ConditionFactory.getCondition("14"),
         ""
        ));

        return list;
    }
}
