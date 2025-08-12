package prayertimesapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class PrayerTimesApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Prayer Times Finder");

        Label cityLabel = new Label("Enter City:");
        cityLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));

        TextField cityInput = new TextField();
        cityInput.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        cityInput.setMaxWidth(600);

        Button searchButton = new Button("Search City");
        searchButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        searchButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        searchButton.disableProperty().bind(cityInput.textProperty().isEmpty());

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        resultArea.setMaxSize(700, 400);
        resultArea.setStyle(
                "-fx-font-family: 'Arial';"
                + "-fx-font-size: 20px;"
        );
        ImageView cityImageView = new ImageView();
        cityImageView.setFitWidth(500);
        cityImageView.setFitHeight(200);
        cityImageView.setPreserveRatio(true);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().addAll(cityLabel, cityInput, searchButton, cityImageView, resultArea);

        Scene scene = new Scene(layout, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        /*-------------------------------------------*/
        // PrayerTimesManager object
        PrayerTimesManager manager = new PrayerTimesManager();

        searchButton.setOnAction(e -> {
            String city = cityInput.getText().trim();
            PrayerTimes times = manager.getPrayerTimes(city);
            if (times != null) {
                resultArea.setText(times.getFormattedPrayerTimes());
                try {
                    File imageFile = new File("src/" + times.getImageUrl());
                    if (imageFile.exists()) {
                        cityImageView.setImage(new Image(times.getImageUrl()));
                    } else {
                        resultArea.appendText("\nImage not found for the city.");
                        cityImageView.setImage(null);
                    }
                } catch (Exception ex) {
                    resultArea.appendText("\nError loading image.");
                    cityImageView.setImage(null);
                }
            } else {
                resultArea.setText("Prayer times for " + city + " are not available.");
                cityImageView.setImage(null);
            }
        });
    }
}

/*--------------------------------------------------------*/
// class PrayerTimesManager
class PrayerTimesManager {

    private final PrayerTimes[] prayerTimesData;

    public PrayerTimesManager() {
        prayerTimesData = new PrayerTimes[]{
            new PrayerTimes("Cairo", "05:15 AM", "12:00 PM", "03:05 PM", "05:30 PM", "06:55 PM", "cairo.jpeg"),
            new PrayerTimes("Riyadh", "05:00 AM", "12:05 PM", "03:10 PM", "05:35 PM", "07:05 PM", "riyadh.jpeg"),
            new PrayerTimes("Dubai", "05:10 AM", "12:20 PM", "03:20 PM", "05:40 PM", "07:00 PM", "Dubai.jpeg"),
            new PrayerTimes("Abu Dhabi", "05:10 AM", "12:20 PM", "03:20 PM", "05:40 PM", "07:00 PM", "abudhabi.jpeg"),
            new PrayerTimes("Amman", "05:10 AM", "12:10 PM", "03:15 PM", "05:35 PM", "06:55 PM", "amman.jpeg"),
            new PrayerTimes("Beirut", "05:10 AM", "12:10 PM", "03:15 PM", "05:35 PM", "06:55 PM", "Beirut.jpeg"),
            new PrayerTimes("Kuwait", "05:10 AM", "12:05 PM", "03:10 PM", "05:30 PM", "07:00 PM", "kuwait.jpeg"),
            new PrayerTimes("Kom Hamada", "05:15 AM", "12:00 PM", "03:05 PM", "05:30 PM", "06:55 PM", "KomHamada.png"),
            new PrayerTimes("London", "06:45 AM", "12:15 PM", "03:15 PM", "05:30 PM", "07:15 PM", "london.jpeg"),
            new PrayerTimes("New York", "06:15 AM", "12:15 PM", "03:15 PM", "05:35 PM", "07:05 PM", "newyork.jpeg"),
            new PrayerTimes("Tokyo", "05:30 AM", "11:40 AM", "02:40 PM", "05:00 PM", "06:30 PM", "tokyo.jpeg"),
            new PrayerTimes("Tunis", "05:40 AM", "12:20 PM", "03:30 PM", "05:40 PM", "06:50 PM", "tunis.jpeg"),
            new PrayerTimes("Casablanca", "06:10 AM", "12:40 PM", "03:50 PM", "05:50 PM", "07:00 PM", "casablanca.jpeg"),
            new PrayerTimes("Algiers", "05:50 AM", "12:30 PM", "03:40 PM", "05:50 PM", "07:10 PM", "algiers.jpeg"),
            new PrayerTimes("Baghdad", "05:00 AM", "12:10 PM", "03:20 PM", "05:40 PM", "07:00 PM", "baghdad.jpeg"),
            new PrayerTimes("Khartoum", "05:15 AM", "12:00 PM", "03:05 PM", "05:30 PM", "06:55 PM", "khartom.jpeg"),
            new PrayerTimes("Marrakech", "06:20 AM", "12:45 PM", "03:55 PM", "05:55 PM", "07:10 PM", "marrakech.jpeg"),
            new PrayerTimes("Damascus", "05:10 AM", "12:10 PM", "03:15 PM", "05:35 PM", "06:55 PM", "damascus.jpeg"),
            new PrayerTimes("Al-Madinah", "05:00 AM", "12:10 PM", "03:15 PM", "05:35 PM", "06:55 PM", "madinah.jpeg"),
            new PrayerTimes("Jeddah", "05:00 AM", "12:10 PM", "03:15 PM", "05:35 PM", "06:55 PM", "jeddah.jpeg"),
            new PrayerTimes("Paris", "06:45 AM", "12:30 PM", "03:30 PM", "05:50 PM", "07:30 PM", "Paris.jpeg"),
            new PrayerTimes("Sydney", "04:30 AM", "11:45 AM", "03:15 PM", "05:40 PM", "07:10 PM", "sedney.jpeg"),
            new PrayerTimes("Moscow", "06:10 AM", "12:00 PM", "03:10 PM", "05:30 PM", "07:15 PM", "moscow.jpeg")
        };
    }

    public PrayerTimes getPrayerTimes(String city) {
        for (PrayerTimes times : prayerTimesData) {
            if (times.getCity().equalsIgnoreCase(city)) {
                return times;
            }
        }
        return null;
    }
}

class PrayerTimes {

    private final String city;
    private final String fajr;
    private final String dhuhr;
    private final String asr;
    private final String maghrib;
    private final String isha;
    private final String imageUrl;

    public PrayerTimes(String city, String fajr, String dhuhr, String asr, String maghrib, String isha, String imageUrl) {
        this.city = city;
        this.fajr = fajr;
        this.dhuhr = dhuhr;
        this.asr = asr;
        this.maghrib = maghrib;
        this.isha = isha;
        this.imageUrl = imageUrl;
    }

    public String getCity() {
        return city;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFormattedPrayerTimes() {
        return "Fajr: " + fajr + "\n"
                + "Dhuhr: " + dhuhr + "\n"
                + "Asr: " + asr + "\n"
                + "Maghrib: " + maghrib + "\n"
                + "Isha: " + isha;
    }
}
