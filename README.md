# Prayer Times Finder

## Description
Prayer Times Finder is a JavaFX desktop application that allows users to find Islamic prayer times for various cities. The application displays the prayer times along with an image related to the searched city.

## Features
- Enter the name of a city to retrieve its prayer times.
- Displays prayer times for Fajr, Dhuhr, Asr, Maghrib, and Isha.
- Shows an image representing the city (if the image file exists).
- User-friendly interface with input validation (search button disabled if input is empty).

## How to Use
1. Run the application.
2. Enter the city name in the input field.
3. Click the **Search City** button.
4. View the prayer times and city image if available.
5. If the city is not found, an error message is displayed.

## Supported Cities
The app includes data for the following cities (case-insensitive search):
- Cairo
- Riyadh
- Dubai
- Abu Dhabi
- Amman
- Beirut
- Kuwait
- Kom Hamada
- London
- New York
- Tokyo
- Tunis
- Casablanca
- Algiers
- Baghdad
- Khartoum
- Marrakech
- Damascus
- Al-Madinah
- Jeddah
- Paris
- Sydney
- Moscow

## Project Structure
- `PrayerTimesApp.java` – Main JavaFX application class with UI and event handling.
- `PrayerTimesManager.java` – Manages prayer times data.
- `PrayerTimes.java` – Data class representing prayer times and city image.
- `src/` – Folder containing city image files (e.g., cairo.jpeg, riyadh.jpeg).

## Requirements
- Java Development Kit (JDK) 8 or higher.
- JavaFX SDK configured in your project.

## How to Run
Compile and run the `PrayerTimesApp` class. Make sure the images are located in the `src/` directory or update the path accordingly.

## Notes
- Image files must be placed in the correct directory (`src/`) for them to display properly.
- The search is case-insensitive but must match city names exactly as defined.

## License
This project is open-source and free to use.

---

If you want, I can help you generate a ready-to-use `.gitignore` or help with any other part!
