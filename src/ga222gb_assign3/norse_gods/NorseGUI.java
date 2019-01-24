package ga222gb_assign3.norse_gods;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NorseGUI extends Application {
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage){
        ArrayList<NorseGod> gods = new ArrayList<>();
        gods.add(new NorseGod("Odin", "Aesir", "Odin (from Old Norse Óðinn) is a widely revered god. In Norse mythology, from which stems most of the information about the god, Odin is associated with wisdom, healing, death, royalty, the gallows, knowledge, battle, sorcery, poetry, frenzy, and the runic alphabet, he is the husband of the goddess Frigg, the King of Asgard and he is also the chief ruler (The Allfather) of the Æsir (the main pantheon of Norse gods) in Norse mythology.[1] Odin is compared to Mercury by Tacitus. In wider Germanic mythology and paganism, Odin was known in Old English as Wōden, in Old Saxon as Wōdan, and in Old High German as Wuotan or Wōtan, all stemming from the reconstructed Proto-Germanic theonym *wōđanaz."));
        gods.add(new NorseGod("Thor", "Aesir", "In Norse mythology, Thor (/θɔːr/; from Old Norse Þórr) is the hammer-wielding Æsir god of thunder, lightning, storms, oak trees, strength, hallowing, fertility, the protection of mankind and of the fortress of Asgard. The son of Odin All-Father and Jörð (the personification of Earth), he is physically the strongest of the Æsir. The cognate deity in wider Germanic mythology and paganism was known in Old English as Þunor (Thunor) and in Old High German as Donar (runic þonar ᚦᛟᚾᚨᚱ), stemming from a Common Germanic *Þunraz, meaning \"thunder\"."));
        gods.add(new NorseGod("Loki", "Giant", "Loki is the Norse god of mischief, as well as of fire. He is the son of two giants, Fárbauti ('cruel striker') and Laufey (or Nál which means 'needle', implying that she was skinny and weak.). His two brothers (who were to be beside him in Ragnarök) are Býleistr (bee-lighting) and Helblindi (All blind or hel-blinder). He is referred to as the blood-brother of Odin. Loki becomes harbinger of Ragnarök and the father of the three chaos monsters: Fenrir, Jörmungandr, and Hel. Loki's mischief and intellect is not to be underestimated, as he is ultimately although indirectly responsible for the deaths of Baldr and Thor, which were caused by Höðr and Jörmungandr (respectively)."));
        gods.add(new NorseGod("Baldr", "Aesir", "Baldr (also Balder, Baldur) is a Æsir god of light, joy, purity, and the summer sun in Norse mythology, and a son of the god Odin and the goddess Frigg. He is the father of Forseti, and He has numerous brothers, such as Thor and Váli. In the 12th century, Danish accounts by Saxo Grammaticus and other Danish Latin chroniclers recorded a euhemerized account of his story. Compiled in Iceland in the 13th century, but based on much older Old Norse poetry, the Poetic Edda and the Prose Edda contain numerous references to the death of Baldr as both a great tragedy to the Æsir and a harbinger of Ragnarök."));
        gods.add(new NorseGod("Freyr", "Vanir", "Freyr (Old Norse: Lord), sometimes anglicized as Frey, is a widely attested god associated with sacral kingship, virility and prosperity, with sunshine and fair weather, and pictured as a phallic fertility god in Norse mythology. Freyr is said to \"bestow peace and pleasure on mortals.\" Freyr, sometimes referred to as Yngvi-Freyr, was especially associated with Sweden and seen as an ancestor of the Swedish royal house."));
        gods.add(new NorseGod("Freyja", "Vanir", "In Norse mythology, Freyja (/ˈfreɪə/; Old Norse for \"(the) Lady\") is a goddess associated with love, sex, beauty, fertility, gold, seiðr, war, and death. Freyja is the owner of the necklace Brísingamen, rides a chariot pulled by two cats, accompanied by the boar Hildisvíni, and possesses a cloak of falcon feathers. By her husband Óðr, she is the mother of two daughters, Hnoss and Gersemi. Along with her twin brother Freyr, her father Njörðr, and her mother (Njörðr's sister, unnamed in sources), she is a member of the Vanir. Stemming from Old Norse Freyja, modern forms of the name include Freya, Freyia, and Freja."));
        gods.add(new NorseGod("Heimdallr", "Aesir", "In Norse mythology, Heimdallr is a god who possesses the resounding horn Gjallarhorn, owns the golden-maned horse Gulltoppr, has gold teeth, and is the son of Nine Mothers, grandson of Aegir and great grandson of Fornjotr. Heimdallr is attested as possessing foreknowledge, keen eyesight and hearing, and keeps watch for the onset of Ragnarök while drinking fine mead in his dwelling Himinbjörg, located where the burning rainbow bridge Bifröst meets heaven. Heimdallr is said to be the originator of social classes among humanity and once regained Freyja's treasured possession Brísingamen while doing battle in the shape of a seal with Loki. Heimdallr and Loki are foretold to kill one another during the events of Ragnarök. "));
        gods.add(new NorseGod("Bragi", "Aesir", "Bragi is generally associated with bragr, the Norse word for poetry. The name of the god may have been derived from bragr, or the term bragr may have been formed to describe 'what Bragi does'. A connection between the name Bragi and English brego 'chieftain' has been suggested but is generally now discounted. That Bragi is Odin's son is clearly mentioned only here and in some versions of a list of the sons of Odin (see Sons of Odin). But \"wish-son\" in stanza 16 of the Lokasenna could mean \"Odin's son\" and is translated by Hollander as Odin's kin."));
        gods.add(new NorseGod("Tyr", "Aesir", "Týr, also known as Tiwaz , Tiw or Ziu, is one of the major deities and the god of combat and heroic glory in Norse mythology, portrayed as a one-handed man. His Greco-Roman equivalent is Ares/Mars. The name Tyr originally meant \"god\" (cf. Hangatyr, the \"god who hung\" (referring to when Odin hung in a tree for nine days) as one of Odin's names; probably inherited from Tyr in his role as judge (compare with the Irish \"Midir\", the judge par excellence) and goes back to a Proto-Germanic Tîwaz, earlier Teiwaz, continuing Proto-Indo-European language *deywos \"god\", a word related to but distinct from the name of the sky-god Dyeus (in lith. both Dyeus and Deywos has the same meaning Dievas or goddess)."));

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10,10,10,10));

        //Title
        Text title = new Text("Norse Gods and other Beings");
        title.setFont(Font.font("Helvetica", FontWeight.BOLD, 25));
        borderPane.setTop(title);

        //Text flow
        Text name = new Text();
        name.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));

        Text race = new Text();
        race.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));

        Text desc = new Text();
        desc.setFont(Font.font("Helvetica", 20));

        TextFlow textFlow = new TextFlow(name, race, desc);
        textFlow.setPadding(new Insets(10, 10, 10, 10));
        textFlow.setLineSpacing(4);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textFlow);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        borderPane.setCenter(scrollPane);

        //List view
        ObservableList<String> names = gods.stream().map(x -> x.getName()).collect(Collectors.toCollection(FXCollections::observableArrayList));
        ListView<String> godList = new ListView<>(names);
        godList.setPrefWidth(150);
        borderPane.setLeft(godList);

        godList.getSelectionModel().selectedIndexProperty().addListener(ov -> {
            name.setText(gods.get(godList.getSelectionModel().getSelectedIndex()).getName() + "\n");
            race.setText(gods.get(godList.getSelectionModel().getSelectedIndex()).getRace() + "\n");
            desc.setText(gods.get(godList.getSelectionModel().getSelectedIndex()).getDesc());
        });

        Scene scene = new Scene(borderPane, 600, 400);
        scene.setFill(Color.LIGHTGREY);
        primaryStage.setTitle("Norse Gods");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
