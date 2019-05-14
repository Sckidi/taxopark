package by.grsu.ruduk.taxopark.model.constants;

public enum UnitType {
    FRONT_WHEEL("Передний привод"),
    REAR_DRIVE("Задний привод");

    private String description;

    UnitType(String description){this.description = description;}
}
