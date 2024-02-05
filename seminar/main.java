package seminar;

public class main {
    public static void main(String[] args) {
        GbList <Integer> gbList = new GbArrayList<>();
        gbList.add(23);
        gbList.add(1);
        gbList.add(22);
        System.out.println(gbList);
        System.out.println(gbList.get(1));
        gbList.remove(1);
        System.out.println(gbList);
    }
}
