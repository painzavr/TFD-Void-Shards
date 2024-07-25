package org.example;

public enum Place {
    Kingstone("Кингстон"),
    SterileLands("Пустоши"),
    Vespers("Сумеречье"),
    EchoSwamp("Топи эха"),
    AgnaDesert("Пустыня Агна"),
    WhiteNightGulch("Лощина Белых ночей"),
    Hagios("Агиос"),
    Fortress("Крепость");

    public final String name;
    Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
