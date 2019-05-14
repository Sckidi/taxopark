package by.grsu.ruduk.taxopark.model.constants;

public enum OrderStatus {
    QUEUE("В очереди"),
    PROCESS("В процессе выполнения"),
    DONE("Выполнен");

    private String description;

    OrderStatus(String description) {this.description = description;}
}
