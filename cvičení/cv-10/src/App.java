public class App {
    public static void main(String[] args) {
        Pole pole = new Pole(2);
        pole.zadejHranol();
        pole.zadejHranol();
        pole.vypoctiObjem();
        pole.vypoctiObsahPodstavy();
        System.out.println(pole.najdiNejmensiObjem());
        System.out.println(pole.zjistiPocetDrevenych());
    }
}
