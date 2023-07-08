import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.addHuman(new Human(01,"Алексей", Gender.Male, LocalDate.of(1965, 12, 4)));
        tree.addHuman(new Human(02,"Светлана", Gender.Female, LocalDate.of(1967, 5, 29)));
        tree.addHuman(new Human(03,"Ольга", Gender.Female, LocalDate.of(1990, 10, 25),
                tree.getByName("Алексей"),tree.getByName("Светлана")));
        tree.addHuman(new Human(03,"Иван", Gender.Female, LocalDate.of(1991, 9, 15),
                tree.getByName("Алексей"),tree.getByName("Светлана")));
        Human grandma = new Human(05,"Ирина",Gender.Female,LocalDate.of(1944,7,20));
        grandma.addChild(tree.getByName("Светлана"));
        tree.addHuman(grandma);
        System.out.println(tree);
    }

}
